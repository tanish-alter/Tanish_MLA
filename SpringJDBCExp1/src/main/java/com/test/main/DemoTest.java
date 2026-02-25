package com.test.main;
 
import java.util.List;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.test.dao.MLATeamDao;
import com.test.dao.MLATeamDao1;
import com.test.model.MLATeam;
 
public class DemoTest {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		MLATeamDao dao=ctx.getBean("tdao", MLATeamDao.class);
		MLATeamDao1 dao1=ctx.getBean("tdao1",MLATeamDao1.class);
		MLATeam obj=new MLATeam();
		obj.setId(103);
		obj.setName("Virat kohli");
		obj.setSkill("cloud developer");
		obj.setManager("Anushka");
		
		dao1.createMLATeam(obj);
		//dao.saveMLATeam(obj);
		//dao.updateMLAteam(obj);
		
		List<MLATeam> list=dao.getAllMembers();
		list.forEach(team->
				System.out.println(team.getId()+" "+team.getName()+ " "+team.getSkill()+" "+team.getManager())
				);
		
		
		
	}
}
 