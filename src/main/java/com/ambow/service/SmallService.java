package com.ambow.service;

import com.ambow.bean.SmallInfo;
import com.ambow.dao.SmallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmallService {
    @Autowired
    private SmallDao smallDao;
    public void addSmall(SmallInfo smallInfo){
        smallDao.addSmall(smallInfo);
    }
    public void delSmall(int id){
        smallDao.delSmall(id);
    }
    public void updateSmall(SmallInfo smallInfo){
        smallDao.updateSmall(smallInfo);
    }
    public List<SmallInfo> selectAll(){
        return smallDao.allSmall();
    }
    public SmallInfo byIdSmall(SmallInfo smallInfo){
        int id=smallInfo.getSid();
        return smallDao.byIdSmall(id);
    }

    public List<SmallInfo> allSmallServicePage(int page, int yetiao) {
        return smallDao.getAllSmallPage(page,yetiao);
    }

    public List<SmallInfo> getSmallInfo(int str) {
        System.out.println("str===="+str);
        return smallDao.getAllSmallByBid(str);
    }

    public SmallInfo selectNameAndType(SmallInfo smallInfo) {
     return smallDao.selectNameAndType(smallInfo);
    }
}

