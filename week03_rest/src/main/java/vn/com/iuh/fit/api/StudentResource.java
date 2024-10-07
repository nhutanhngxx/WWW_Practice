package vn.com.iuh.fit.api;

import vn.com.iuh.fit.business.BaseProcess;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import vn.com.iuh.fit.models.Student;


@Path("/students")
public class StudentResource {

    @Inject
    private BaseProcess process;

    // Phương thức này sẽ thêm một sinh viên mới
    @POST
    public Response addStudent(Student student) {
        Response.ResponseBuilder builder = Response.ok();
        builder.entity(process.persist(student));
        return builder.build();
    }

    // Phương thức này sẽ trả về tất cả sinh viên
    @GET
    public Response getAllStudents() {
        Response.ResponseBuilder builder = Response.ok();
        builder.entity(process.getAllStudents());
        return builder.build();
    }

    // Phương thức này sẽ trả về một sinh viên dựa trên id
    @GET
    @Path("/{id}") // Thêm vào khi cần truy cập theo id
    public Response getById(@PathParam("id") long id) {
        Response.ResponseBuilder builder = Response.ok();
        builder.entity(process.getById(id));
        return builder.build();
    }


}
