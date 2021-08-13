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
    private String mname;
    private String label;
    private String url;
    private Integer pid;
    private String icon;
    private String checked;
    private String disabled;
    private Integer sort;
    private List<?> children;

    public Menu() {
    }

    public Menu(Integer id, String mname, String label, String url, Integer pid, String icon, String checked, String disabled, Integer sort, List<?> children) {
        this.id = id;
        this.mname = mname;
        this.label = label;
        this.url = url;
        this.pid = pid;
        this.icon = icon;
        this.checked = checked;
        this.disabled = disabled;
        this.sort = sort;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", checked='" + checked + '\'' +
                ", disabled='" + disabled + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(mname, menu.mname) && Objects.equals(label, menu.label) && Objects.equals(url, menu.url) && Objects.equals(pid, menu.pid) && Objects.equals(icon, menu.icon) && Objects.equals(checked, menu.checked) && Objects.equals(disabled, menu.disabled) && Objects.equals(sort, menu.sort) && Objects.equals(children, menu.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mname, label, url, pid, icon, checked, disabled, sort, children);
    }
}
