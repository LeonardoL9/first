import entity.HardMember;
import entity.MakerMember;
import service.MemberServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MakerMemberSystem {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动与连接
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lp","root","lpsql903982");
        //获取数据
        Statement makerMembers=con.createStatement();

        MemberServiceImpl memberService=new MemberServiceImpl();

        System.out.println("查询所有成员");
        memberService.selectAllMember(makerMembers);
        System.out.println();


        System.out.println("根据id查询");
        MakerMember makerMember=memberService.selectByIDMember(makerMembers,1);
        System.out.println(makerMember.toString());
        System.out.println();

        System.out.println("根据性别查询");
        memberService.selectBySexMember(makerMembers,false);
        System.out.println();

        System.out.println("通过id删除成员并查询");
        memberService.DeleteMember(makerMembers,1);
        System.out.println();

        System.out.println("修改并查询");
        MakerMember makerMember7  = new HardMember(7, "小刘", "9999", "2001-11-25", false, 4);
        memberService.updateByIdMember(makerMembers,makerMember7);
        System.out.println();

        /*System.out.println("查询成员的headManId");
        memberService.selectMemberHeadMan(makerMembers,makerMember);
        System.out.println();*/

      /*  System.out.println("添加成员");
        MakerMember member8=new HardMember(8,"小亮","8888","2003-04-18",true,4);
        memberService.addMember(makerMembers,member8);*/





        //关闭资源
        makerMembers.close();
        con.close();
    }
}