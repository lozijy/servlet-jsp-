package com.Lozijy.dao.user;

import com.Lozijy.dao.BaseDao;
import com.Lozijy.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws Exception {
        //准备3个参数，一个为结果，两个为execute的参数
        User user = new User();
        ResultSet rs=null;
        PreparedStatement ps=null;
        String sql="select * from user where userCode=?";
        Object[] params={userCode};

        rs = BaseDao.execute(connection, sql, params, rs, ps);
        if(rs.next()){
            user.setIdPicPath(rs.getString("IdPicPath"));
            user.setWorkPicPath(rs.getString("WorkPicPath"));
            user.setAddress(rs.getString("address"));
            user.setUserCode(rs.getString("UserCode"));
            user.setBirthday(rs.getDate("birthday"));
            user.setUserName(rs.getString("userName"));
            user.setUserPassword(rs.getString("userPassword"));
            user.setPhone(rs.getString("Phone"));
            user.setUserRole(rs.getInt("userRole"));
            user.setCreationDate(rs.getDate("CreationDate"));
            user.setCreatedBy(rs.getInt("CreateBy"));
            user.setGender(rs.getInt("Gender"));
        }
        return user;
    }

    @Override
    public int updatePwd(Connection connection, int id, String pwd) throws Exception {
        return 0;
    }

    @Override
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception {
        return 0;
    }

    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        return null;
    }

    @Override
    public int add(Connection connection, User user) throws Exception {
        return 0;
    }

    @Override
    public int deleteUserById(Connection connection, Integer delId) throws Exception {
        return 0;
    }

    @Override
    public int modify(Connection connection, User user) throws Exception {
        return 0;
    }

    @Override
    public User getUserById(Connection connection, String id) throws Exception {
        return null;
    }
}

