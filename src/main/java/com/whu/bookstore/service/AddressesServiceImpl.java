package com.whu.bookstore.service;

import com.whu.bookstore.dao.AddressesMapper;
import com.whu.bookstore.entity.Address;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：qx.w
 * @description：地址类服务实现类
 * @modified By：
 * @since ：Created in 2020/3/7 11:16
 */
@Service
public class AddressesServiceImpl implements IAddressesService {
    @Resource
    AddressesMapper addressesMapper;

    @Override
    public List<Address> getByUser(String username) {
        return addressesMapper.selectByUser(username);
    }

    @Override
    public int insertAddress(String uuid, String username, String name, String phone, String location) {
        Address address = new Address();
        address.setUuid(uuid);
        address.setUsername(username);
        address.setName(name);
        address.setPhone(phone);
        address.setLocation(location);
        return addressesMapper.insertAddress(address);
    }

    @Override
    public int updateAddress(String uuid, String username, String name, String phone, String location) {
        Address address = new Address();
        address.setUuid(uuid);
        address.setUsername(username);
        address.setName(name);
        address.setPhone(phone);
        address.setLocation(location);
        return addressesMapper.updateAddress(address);
    }

    @Override
    public int deleteAddress(String uuid) {
        return addressesMapper.deleteAddress(uuid);
    }
}
