package com.chemo.hdz.tinytaskdemo.entities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by chemo on 4/27/17.
 */

@Table(name = "Hability")
public class Hability extends Model {
    @Column(name = "id_hability")
    public int hability;

    @Column(name = "description")
    public String description;

    public Hability() {
        super();
    }

    public Hability(int hability, String description) {
        super();
        this.hability = hability;
        this.description = description;
    }
}
