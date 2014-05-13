package com.loftcat.ourclub.model.vo;

import java.io.Serializable;
import java.util.Date;

import android.os.Parcelable;


public class VedioVo implements Vo,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int media_id;
	private String media_name;
	private String media_prefix;
	private int club_id;
	private int album_id;
	private String vedio_img;

	public int getMedia_id() {
		return media_id;
	}

	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}

	public String getMedia_name() {
		return media_name;
	}

	public void setMedia_name(String media_name) {
		this.media_name = media_name;
	}

	public String getMedia_prefix() {
		return media_prefix;
	}

	public void setMedia_prefix(String media_prefix) {
		this.media_prefix = media_prefix;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getVedio_img() {
		return vedio_img;
	}

	public void setVedio_img(String vedio_img) {
		this.vedio_img = vedio_img;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	public String getAdd_user() {
		return add_user;
	}

	public void setAdd_user(String add_user) {
		this.add_user = add_user;
	}

	private Date add_time;
	private String add_user;
}
