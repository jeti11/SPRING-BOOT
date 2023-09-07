package com.bitc.board3.mapper;

import com.bitc.board3.dto.AddressDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {

  Page<AddressDTO> getAddressList() throws Exception;
}
