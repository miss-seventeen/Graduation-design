package com.ambow.service;

import com.ambow.bean.BigInfo;
import com.ambow.dao.BigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigService {
@Autowired
    private BigDao bigDao;
    public void addBig(BigInfo bigInfo){
        bigDao.addBig(bigInfo);
    }
    public void delBig(int id){
        bigDao.delBig(id);
    }
    public void updateBig(BigInfo bigInfo){
        bigDao.updateBig(bigInfo);
    }
    public List<BigInfo> selectAll(){
        return bigDao.allBig();
    }
    public BigInfo byIdBig(BigInfo bigInfo){
        int id=bigInfo.getBid();
        return bigDao.byIdBig(id);
    }

    public List<BigInfo> allBigServicePage(int page, int yetiao) {
        return bigDao.getAllBigPage(page,yetiao);
    }

    public BigInfo selectNameAndType(BigInfo bigInfo) {
     return bigDao.selectNameAndType(bigInfo);
    }
}
