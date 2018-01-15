package service;

import org.springframework.stereotype.Service;

import entity.User;
//2.业务层接口实现
@Service
	public class TestInterFaceImpl implements TestInterFace {
	    @Override
		public int testInterFace() {
	    return 0;
	    }

	    @Override 
	    public User testUser() {
	    return new User();
	    
	}
}
