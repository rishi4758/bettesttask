package com.example.betpawa.services;

import java.util.List;

import com.example.betpawa.model.MyComments;
import com.example.betpawa.model.MyList;

public interface ListService {
	public List<MyList>getList();
	public MyList addList(MyList listData);
	public MyList editList(MyList list);
	public MyList addComment(long listId, MyComments cmt);
}
