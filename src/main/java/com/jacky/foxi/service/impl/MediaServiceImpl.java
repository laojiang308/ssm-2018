package com.jacky.foxi.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.jacky.foxi.dao.MediaDao;
import com.jacky.foxi.entity.Media;
import com.jacky.foxi.service.MediaService;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	@Resource
	private MediaDao mediaDao;

	@Override
	public long createMedia(Media media) {
		return mediaDao.createMedia(media);
	}

}
