package com.sena.servicesecurity.IRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.Entity.Role;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{
    @Query(value = " SELECT "
					+ " r.id,	"
					+ " r.name role, "
                    + " r.descripcion role"
					+ " CONCAT(p.first_name,' ',p.last_name) personName, "
					+ " p.email personEmail, "
					+ " r.state "
					+ "FROM "
					+ "	user r "
					+ "    INNER JOIN person p ON p.id = r.person_id "
					+ "WHERE "
					+ "	r.username = :username AND "
					+ " r.password = :password  ", nativeQuery = true)
			Optional<IUserDto> getListRole(String username, String password);

}
