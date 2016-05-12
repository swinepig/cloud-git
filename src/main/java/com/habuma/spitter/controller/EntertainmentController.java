package com.habuma.spitter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.habuma.spitter.entity.MusicInfo;

@Controller
@RequestMapping(value = "/Entertainment")
public class EntertainmentController extends BaseController{

	
	/**
	 * 获取音乐播放列表
	 * */
	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public @ResponseBody
	List<MusicInfo> porfile() {
		List<MusicInfo> list = new ArrayList<MusicInfo>();
		MusicInfo info1 = new MusicInfo("直到世界终结", "灌篮高手",
				"../resources/mp3/1.mp3","");
		MusicInfo info2 = new MusicInfo("亡灵序曲", "WOW",
				"../resources/mp3/The Dawn.mp3","");
		list.add(info1);
		list.add(info2);
		return list;
	}
	
	@RequestMapping(value="goMusicPage",method=RequestMethod.GET)
	public String goMusicPage(){
		return "music";
	}
}
