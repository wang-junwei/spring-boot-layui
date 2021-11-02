package com.wjw.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @Author: wjw
 * @Date: 2021/8/9 16:00
 */
@Getter
@Setter
public class Menu {
    private Integer id;
    private String index;
    private String mname;
    private String label;
    private String url;
    private Integer pid;
    private String icon;
    private String checked;
    private String disabled;
    private Integer sort;
    private List<?> children;
    private String component;

    public Menu() {
    }

    public Menu(Integer id, String index, String mname, String label, String url, Integer pid, String icon, String checked, String disabled, Integer sort, List<?> children, String component) {
        this.id = id;
        this.index = index;
        this.mname = mname;
        this.label = label;
        this.url = url;
        this.pid = pid;
        this.icon = icon;
        this.checked = checked;
        this.disabled = disabled;
        this.sort = sort;
        this.children = children;
        this.component = component;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", mname='" + mname + '\'' +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", checked='" + checked + '\'' +
                ", disabled='" + disabled + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                ", component='" + component + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(index, menu.index) && Objects.equals(mname, menu.mname) && Objects.equals(label, menu.label) && Objects.equals(url, menu.url) && Objects.equals(pid, menu.pid) && Objects.equals(icon, menu.icon) && Objects.equals(checked, menu.checked) && Objects.equals(disabled, menu.disabled) && Objects.equals(sort, menu.sort) && Objects.equals(children, menu.children) && Objects.equals(component, menu.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, mname, label, url, pid, icon, checked, disabled, sort, children, component);
    }
}
