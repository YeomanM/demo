package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.GroupRightRel;
import com.example.demo.entity.dao.Right;
import com.example.demo.entity.dao.UserGroup;
import com.example.demo.entity.dao.UserGroupRel;
import com.example.demo.mapper.GroupRightRelMapper;
import com.example.demo.mapper.RightMapper;
import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.mapper.UserGroupRelMapper;
import com.example.demo.service.RightService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2019-01-20
 */
@Service
public class RightServiceImpl extends ServiceImpl<RightMapper, Right> implements RightService {

    @Autowired
    private UserGroupRelMapper userGroupRelMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private GroupRightRelMapper groupRightRelMapper;

    @Autowired
    private RightMapper rightMapper;

    @Override
    public BaseResponse getRightTree(Integer userId) {
        Map<String,Object> params = new HashMap<>(1);
        params.put("user_id",userId);
        List<UserGroupRel> userGroupRels = userGroupRelMapper.selectByMap(params);

        List<UserGroup> groups = new ArrayList<>();
        for (UserGroupRel rel : userGroupRels){
            groups.add(userGroupMapper.selectById(rel.getGroupId()));
        }
        return ResponseUtil.successResponse(this.getRightByGroupList(groups));
    }

    @Override
    public Object getRightTreeByGroup(Integer groupId) {
        List<Right> groupRight = null;
        Map<String,Object> params ;
        if (groupId != null){
            params = new HashMap<>(2);
            params.put("group_id",groupId);
            params.put("deleted","0");
            List<GroupRightRel> rels = groupRightRelMapper.selectByMap(params);
            List<Integer> tmp = new ArrayList<>();
            for (GroupRightRel rel : rels){
                tmp.add(rel.getRightId());
            }
            if (!tmp.isEmpty()){
                EntityWrapper<Right> ew = new EntityWrapper<>();
                ew.setEntity(new Right());
                ew.eq("deleted","0");
                ew.in("right_id",tmp);
                groupRight = rightMapper.selectList(ew);
            }
        }
        boolean edit = groupRight != null;
        params = new HashMap<>(2);
        params.put("deleted","0");
        params.put("parent_id","0");
        List<Right> rights = rightMapper.selectByMap(params);
        List<Right> tmp = null,fixed = new ArrayList<>();
        List<Map<String,Object>> result = new ArrayList<>(),list;
        Map<String,Object> map,m ;
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("type","0");
        object.put("isChecked","1");
        array.add(object);
        EntityWrapper<Right> ew = null;
        for (Right right : rights){
            map = new HashMap<>(4);
            map.put("rightId",right.getId());
            map.put("title",right.getTitle());
            map.put("parentId",right.getParentId());
            if (edit && groupRight.contains(right)){
                map.put("checkArr",array);
            }
            result.add(map);
            ew = new EntityWrapper<>();
            ew.eq("parent_id",right.getParentId()).eq("deleted","0");
            tmp = rightMapper.selectList(ew);
            list = new ArrayList<>();
            for (Right r : tmp){
                m = new HashMap<>(4);
                m.put("id",right.getId());
                m.put("title",right.getTitle());
                m.put("parentId",right.getParentId());
                m.put("children",fixed);
                list.add(m);
            }
            map.put("children",list);
        }
        map = new HashMap<>(2);
        object = new JSONObject();
        object.put("code",200);
        object.put("message","操作成功");
        map.put("status",object);
        map.put("data",result);
        return map;
    }

    @Override
    public BaseResponse getAllRight() {
        Map<String,Object> params = new HashMap<>(1);
        params.put("deleted",0);
        return ResponseUtil.successResponse(rightMapper.selectByMap(params));
    }


    private List<Map<String,Object>> getRightByGroupList(List<UserGroup> groups){
        Map<String,Object> params = null;
        List<GroupRightRel> groupRightRels = new ArrayList<>();
        for (UserGroup group:groups){
            params = new HashMap<>(1);
            params.put("group_id",group.getId());
            groupRightRels.addAll(groupRightRelMapper.selectByMap(params));
        }

        params = new HashMap<>(2);

        params.put("parent_id",0);
        List<Right> rights = new ArrayList<>();
        for (GroupRightRel rightRel : groupRightRels){
            params.put("id",rightRel.getRightId());
            params.put("deleted",0);
            rights.addAll(rightMapper.selectByMap(params));
        }

        Map<String,Object> result = null;
        List<Right> list = null;
        List<Map<String,Object>> r = new ArrayList<>();
        JSON o = null;
        for (Right right : rights){
            params.put("parent_id",right.getId());
            list = new ArrayList<>();
            for (GroupRightRel rightRel : groupRightRels){
                params.put("id",rightRel.getRightId());
                list.addAll(rightMapper.selectByMap(params));
            }
            o = (JSON) JSONObject.toJSON(right);
            result = JSONObject.toJavaObject(o,Map.class);
            result.put("children",list);
            r.add(result);
        }
        return r;
    }


}
