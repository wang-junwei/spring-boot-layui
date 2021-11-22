package com.wjw.controller;

import com.wjw.commons.ResultJson;
import com.wjw.pojo.Menu;
import com.wjw.pojo.RoleMenu;
import com.wjw.service.MenuService;
import com.wjw.service.RoleMenuService;
import com.wjw.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: wjw
 * @Date: 2021/8/11 9:03
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleServiceImpl;
    @Resource
    private MenuService menuServiceImpl;
    @Resource
    private RoleMenuService roleMenuServiceImpl;

    /**
     * 角色管理页面
     *
     * @return role
     */
    @PostMapping("/roleManager")
    public String roleManager() {
        return "/views/role";
    }

    /**
     * 查询角色
     *
     * @param roleName 角色名
     * @param page     页码
     * @param limit    条数
     * @return resultJson
     */
    @PostMapping("/getRole")
    @ResponseBody
    public ResultJson getRole(String roleName, @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "20") Integer limit) {
        long time = System.currentTimeMillis();
        ResultJson allRole = roleServiceImpl.getAllRole(roleName, page, limit);
        System.out.println(System.currentTimeMillis() - time);
        return allRole;
    }

    /**
     * 角色权限页面
     *
     * @param roleId   角色id
     * @param roleName 角色名
     * @param model    model
     * @return 页面
     */
    @GetMapping("/permission")
    public String rolePermission(Integer roleId, String roleName, Model model) {
        model.addAttribute("roleId", roleId);
        model.addAttribute("roleName", roleName);
        return "/views/role_permission";
    }

    /**
     * 角色权限回显
     *
     * @param roleId  角色id
     * @return map
     */
    @PostMapping("/getRolePermission")
    @ResponseBody
    public Map<String, Object> getAllMenu(@RequestBody String roleId) {
        Map<String, Object> map = new HashMap<>(16);
        List<Integer> checkedList = new ArrayList<>();
        // 查询所有菜单
        List<Menu> menus = menuServiceImpl.getAllMenu();

        // 分割从前端传的roleId
        String[] roleIds = roleId.split("=");

        // 查询用户有权限的二级菜单
        List<Menu> menuByRoleId = roleMenuServiceImpl.getSecondMenuByUser(roleIds[1]);

        for (Menu menu : menus) {
            // 一级菜单下所有二级菜单
            List<Menu> children = (List<Menu>) menu.getChildren();

            // 遍历二级菜单
            for (Menu m : children) {
                // 用户有权限的菜单中是否包含二级菜单
                if (menuByRoleId.contains(m)) {
                    m.setChecked("true");
                    checkedList.add(m.getId());
                }
            }
        }

        map.put("code", 0);
        map.put("data", menus);
        map.put("checked", checkedList);


        return map;
    }

    /**
     * 保存角色权限
     *
     * @param roleId  角色id
     * @param menuIds 菜单id数组
     * @return map
     */
    @PostMapping("/savePermission")
    @ResponseBody
    public Map<String, Object> savePermission(Integer roleId, Integer[] menuIds) {
        Map<String, Object> map = new HashMap<>(16);

        if (menuIds == null) {
            // 查询是否有权限数据
            Integer permissionByRoleId = roleMenuServiceImpl.getPermissionByRoleId(roleId);

            if (permissionByRoleId > 0) {
                // 删除角色权限
                roleMenuServiceImpl.delRoleMenuByRoleId(roleId);
            }

            map.put("code", "200");
            map.put("msg", "权限分配成功！");
            return map;
        }

        // 查询是否有权限数据
        Integer permissionByRoleId = roleMenuServiceImpl.getPermissionByRoleId(roleId);

        if (permissionByRoleId > 0) {
            // 先删除角色权限
            roleMenuServiceImpl.delRoleMenuByRoleId(roleId);
        }

        List<RoleMenu> roleMenuList = new ArrayList<>();

        for (int menuId : menuIds) {
            // 创建RoleMenu对象
            RoleMenu roleMenu = new RoleMenu();
            // 查询菜单排序
            Menu menu = menuServiceImpl.getMenuById(menuId);
            Integer sort = menu.getSort();

            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenu.setSort(sort);

            roleMenuList.add(roleMenu);
        }

        Integer addRoleMenu = roleMenuServiceImpl.addRoleMenu(roleMenuList);

        if (menuIds.length == addRoleMenu) {
            map.put("code", "200");
            map.put("msg", "权限分配成功！");
            return map;
        }

        map.put("code", "300");
        map.put("msg", "权限分配失败！");

        return map;
    }
}
