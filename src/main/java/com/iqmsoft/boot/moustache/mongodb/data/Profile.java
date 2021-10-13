package com.iqmsoft.boot.moustache.mongodb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
//@RequiredArgsConstructor
public class Profile implements Serializable {
    public Profile(String name) {
		this.name = name;
	}
	public static String MODEL_NAME = "profile";
    public static String MODEL_LIST_NAME = "profiles";
    private static final long serialVersionUID = 3834429806715738570L;

   
    @Id public String id;
    @NonNull public String name;
}
