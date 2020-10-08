package com.example.betpawa.services;

import java.util.Collections;
import java.util.List;

import com.example.betpawa.model.MyComments;
import com.example.betpawa.model.MyList;
import com.example.betpawa.repository.CommentsRepo;
import com.example.betpawa.repository.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService{

	@Autowired
	ListRepo listRepo;

	@Autowired
	CommentsRepo commentsRepo;

	@Override
	public List<MyList> getList() {
		return listRepo.findAll();
	}

	@Override
	public MyList addList(MyList listData) {
		return listRepo.save(listData);
	}

	@Override
	public MyList editList(MyList list) {
		return listRepo.save(list);
	}

	@Override
	public MyList addComment(long listId, MyComments comments) {
		MyList list = listRepo.findById(listId).orElse(null);
		if(list == null){
			return null;
		}
		if(list.getComments() == null){
			list.setComments(Collections.singletonList(comments));
		}else {
			list.getComments().add(comments);
		}
		commentsRepo.save(comments);
		listRepo.save(list);
		return list;
	}
}