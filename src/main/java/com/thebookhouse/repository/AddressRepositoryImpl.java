package com.thebookhouse.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.thebookhouse.model.Address;

public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager em;

    public String getFullAddressFromReference(Address address) {
        StringBuilder sql = new StringBuilder();
        sql.append("select ar.CITY as city, ar.DISTRICT as district, ar.WARD as ward from ADDRESS_REFERENCE as ar ");
        sql.append("where ar.CITY_CODE = :cityCode ");
        sql.append("and ar.DISTRICT_CODE = :districtCode ");
        sql.append("and ar.WARD_CODE = :wardCode");
        Query query = em.createQuery(sql.toString());
        query.setParameter("cityCode", address.getCityCode());
        query.setParameter("districtCode", address.getDistrictCode());
        query.setParameter("wardCode", address.getWardCode());
        AddressReference addressReference = (AddressReference) query.getSingleResult();
        return addressReference.getCity()
                + ", " + addressReference.getDistrict()
                + ", " + addressReference.getWard();
    }

    private class AddressReference {

        private String city;

        private String district;

        private String ward;

        public String getCity() {
            return city;
        }

        public String getDistrict() {
            return district;
        }

        public String getWard() {
            return ward;
        }
    }

}
