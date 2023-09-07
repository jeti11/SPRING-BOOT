package com.bitc.board1.service;

import com.bitc.board1.dto.AreaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
  @Override
  public List<AreaDTO> getDistrictList(String cityName) throws Exception {
    List<AreaDTO> districtList = new ArrayList<>();

    switch (cityName) {
      case "서울":
        AreaDTO se1 = new AreaDTO();
        AreaDTO se2 = new AreaDTO();
        AreaDTO se3 = new AreaDTO();
        AreaDTO se4 = new AreaDTO();

        se1.setAreaName("강북구");
        se2.setAreaName("강남구");
        se3.setAreaName("강서구");
        se4.setAreaName("강동구");

        districtList.add(se1);
        districtList.add(se2);
        districtList.add(se3);
        districtList.add(se4);
      break;

      case "대전":
        AreaDTO dj1 = new AreaDTO();
        AreaDTO dj2 = new AreaDTO();
        AreaDTO dj3 = new AreaDTO();
        AreaDTO dj4 = new AreaDTO();

        dj1.setAreaName("동구");
        dj2.setAreaName("중구");
        dj3.setAreaName("서구");
        dj4.setAreaName("유성구");

        districtList.add(dj1);
        districtList.add(dj2);
        districtList.add(dj3);
        districtList.add(dj4);
        break;

      case "대구":
        AreaDTO dg1 = new AreaDTO();
        AreaDTO dg2 = new AreaDTO();
        AreaDTO dg3 = new AreaDTO();
        AreaDTO dg4 = new AreaDTO();

        dg1.setAreaName("달서구");
        dg2.setAreaName("달서군");
        dg3.setAreaName("수성구");
        dg4.setAreaName("중구");

        districtList.add(dg1);
        districtList.add(dg2);
        districtList.add(dg3);
        districtList.add(dg4);
        break;

      case "부산":
        AreaDTO bs1 = new AreaDTO();
        AreaDTO bs2 = new AreaDTO();
        AreaDTO bs3 = new AreaDTO();
        AreaDTO bs4 = new AreaDTO();

        bs1.setAreaName("부산진구");
        bs2.setAreaName("해운대구");
        bs3.setAreaName("동래구");
        bs4.setAreaName("영도구");

        districtList.add(bs1);
        districtList.add(bs2);
        districtList.add(bs3);
        districtList.add(bs4);
        break;
    }

    return districtList;
  }

  @Override
  public List<AreaDTO> getTownList(String districtName) throws Exception {
    List<AreaDTO> townList = new ArrayList<>();

    switch (districtName) {
      case "강남구":
        AreaDTO kn1 = new AreaDTO();
        AreaDTO kn2 = new AreaDTO();
        AreaDTO kn3 = new AreaDTO();
        AreaDTO kn4 = new AreaDTO();

        kn1.setAreaName("강남1동");
        kn2.setAreaName("강남2동");
        kn3.setAreaName("강남3동");
        kn4.setAreaName("강남4동");

        townList.add(kn1);
        townList.add(kn2);
        townList.add(kn3);
        townList.add(kn4);
        break;

      case "유성구":
        AreaDTO us1 = new AreaDTO();
        AreaDTO us2 = new AreaDTO();
        AreaDTO us3 = new AreaDTO();
        AreaDTO us4 = new AreaDTO();

        us1.setAreaName("유성1동");
        us2.setAreaName("유성2동");
        us3.setAreaName("유성3동");
        us4.setAreaName("유성4동");

        townList.add(us1);
        townList.add(us2);
        townList.add(us3);
        townList.add(us4);
        break;

      case "달서구":
        AreaDTO ds1 = new AreaDTO();
        AreaDTO ds2 = new AreaDTO();
        AreaDTO ds3 = new AreaDTO();
        AreaDTO ds4 = new AreaDTO();

        ds1.setAreaName("달서1동");
        ds2.setAreaName("달서2동");
        ds3.setAreaName("달서3동");
        ds4.setAreaName("달서4동");

        townList.add(ds1);
        townList.add(ds2);
        townList.add(ds3);
        townList.add(ds4);
        break;

      case "부산진구":
        AreaDTO bj1 = new AreaDTO();
        AreaDTO bj2 = new AreaDTO();
        AreaDTO bj3 = new AreaDTO();
        AreaDTO bj4 = new AreaDTO();

        bj1.setAreaName("부진1동");
        bj2.setAreaName("부진2동");
        bj3.setAreaName("부진3동");
        bj4.setAreaName("부진4동");

        townList.add(bj1);
        townList.add(bj2);
        townList.add(bj3);
        townList.add(bj4);
        break;
    }
    return townList;
  }
}
