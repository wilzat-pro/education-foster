package org.crown.project.system.student.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.crown.common.annotation.Log;
import org.crown.common.enums.BusinessType;
import org.crown.common.utils.poi.ExcelUtils;
import org.crown.common.utils.security.ShiroUtils;
import org.crown.framework.enums.ErrorCodeEnum;
import org.crown.framework.model.ExcelDTO;
import org.crown.framework.responses.ApiResponses;
import org.crown.framework.utils.ApiAssert;
import org.crown.framework.web.controller.WebController;
import org.crown.framework.web.page.TableData;
import org.crown.project.system.post.service.IPostService;
import org.crown.project.system.role.service.IRoleService;
import org.crown.project.system.student.domain.Student;
import org.crown.project.system.student.service.IStudentService;
import org.crown.project.system.user.domain.User;
import org.crown.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户信息
 *
 * @author Crown
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends WebController<User> {

    private final String prefix = "system/student";

    @Autowired
    private IStudentService studentService;

//    @Autowired
//    private IRoleService roleService;
//
//    @Autowired
//    private IPostService postService;

    @RequiresPermissions("system:student:view")
    @GetMapping
    public String user() {
        return prefix + "/student";
    }

    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableData<Student> list(Student student) {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getTableData(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:student:export")
    @PostMapping("/export")
    @ResponseBody
    public ExcelDTO export(Student student) {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtils<Student> util = new ExcelUtils<>(Student.class);
        return new ExcelDTO(util.exportExcel(list, "用户数据"));
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:student:import")
    @PostMapping("/importData")
    @ResponseBody
    public ApiResponses<Void> importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtils<Student> util = new ExcelUtils<>(Student.class);
        List<Student> studentList = util.importExcel(file.getInputStream());
        String message = studentService.importStudent(studentList, updateSupport);
        return success().setMsg(message);
    }

    @RequiresPermissions("system:student:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public ExcelDTO importTemplate() {
        ExcelUtils<Student> util = new ExcelUtils<>(Student.class);
        return new ExcelDTO(util.importTemplateExcel("用户数据"));
    }

    /**
     * 新增用户
     */
    @GetMapping("/addStudent")
    public String addStudent(ModelMap mmap) {
//        mmap.put("roles", roleService.selectRoleAll());
//        mmap.put("posts", postService.list());
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/addStudent")
    @ResponseBody
    public void addStudentSave(@Validated Student student) {
        ApiAssert.isTrue(ErrorCodeEnum.USER_ACCOUNT_EXIST.overrideMsg(String.format("学号[%s]已存在", student.getStudentId())),
                studentService.checkStudentIDUnique(student.getStudentId()));
        ApiAssert.isTrue(ErrorCodeEnum.USER_PHONE_EXIST.overrideMsg(String.format("手机号[%s]已存在", student.getTelephone())),
                studentService.checkPhoneUnique(student));
        ApiAssert.isTrue(ErrorCodeEnum.USER_EMAIL_EXIST.overrideMsg(String.format("邮箱[%s]已存在", student.getEmail())),
                studentService.checkEmailUnique(student));
        studentService.insertStudent(student);
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") Long studentId, ModelMap mmap) {
        mmap.put("student", studentService.selectStudentByStudentId(studentId));
//        mmap.put("roles", roleService.selectRolesByUserId(userId));
//        mmap.put("posts", postService.selectAllPostsByUserId(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public void editSave(@Validated Student student) {
        ApiAssert.isTrue(ErrorCodeEnum.USER_PHONE_EXIST.overrideMsg(String.format("手机号[%s]已存在", student.getTelephone())),
                studentService.checkPhoneUnique(student));
        ApiAssert.isTrue(ErrorCodeEnum.USER_EMAIL_EXIST.overrideMsg(String.format("邮箱[%s]已存在", student.getEmail())),
                studentService.checkEmailUnique(student));
        studentService.updateStudent(student);
    }


    @RequiresPermissions("system:student:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public void remove(String ids) {
        studentService.deleteStudentByIds(ids);
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public boolean checkStudentIDUnique(Student student) {
        return studentService.checkStudentIDUnique(student.getStudentId());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public boolean checkPhoneUnique(Student student) {
        return studentService.checkPhoneUnique(student);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public boolean checkEmailUnique(Student student) {
        return studentService.checkEmailUnique(student);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:student:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public void changeStatus(Student student) {
        studentService.changeStatus(student);
    }
}