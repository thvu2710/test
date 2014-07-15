package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Danhmuc;
import entity.Sanpham;
import model.*;

@Path("service")
public class Service {
	SanPhamModel sp = new SanPhamModel();
	DanhMucModel dm = new DanhMucModel();

	// db tam thoi
	static ArrayList<Person> p = new ArrayList<Person>();
	static {
		for (int i = 0; i < 10; i++) {
			Person person = new Person();
			person.setId(i);
			person.setFullName("Person thu " + i);
			person.setAge(new Random().nextInt(40));
			p.add(person);
		}
	}

	@GET
	@Path("/getPersonByIdXML/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Person getPersonByIdXML(@PathParam("id") int id) {
		return p.get(id);
	}

	@GET
	@Path("/getPersonByIdJSON/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonByIdJSON(@PathParam("id") int id) {
		return p.get(id);
	}

	@GET
	@Path("/getAllPersonXML")
	@Produces(MediaType.APPLICATION_XML)
	public List<Person> getAllPersonByIdXML() {
		return p;
	}

	@GET
	@Path("/getAllPersonJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersonByIdJSON() {
		return p;
	}

	@GET
	@Path("/findallsp")
	@Produces(MediaType.APPLICATION_XML)
	public List<Sanpham> finAllSP() {
		return sp.findAll();
	}
	@GET
	@Path("/findalldm")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Danhmuc> finAllDM() {
		return dm.findAll();
	}
}
