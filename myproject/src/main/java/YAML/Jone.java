package YAML;


import java.io.FileNotFoundException;


import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

//写入YAML文件



public class Jone {
public static void main(String[] args) throws FileNotFoundException {
	Person john=new Person();
	john.setAge(37);
	john.setName("John Smith");
	Person sponse=new Person();
	sponse.setName("Jane Smith");
	sponse.setAge(25);
	john.setSponse(sponse);
	Person[ ] children ={new Person(),new Person()};
	children[0].setName("Jimmy Smith");
	children[0].setAge(15);
	children[1].setName("jenny Smith");
	children[1].setAge(12);
	john.setChildren(children);
	/*
	 * 使用SnakeYAML将john dump出来，**如果有引用相同对象，
	 * 则dump出到yaml文件会自动使用<kbd>&</kbd>和<kbd>*</kbd>进行锚点和引用**：
	 */
	
	DumperOptions options = new DumperOptions();
	options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	Yaml yaml = new Yaml(options);
	
	String dump = yaml.dump(john);
	System.out.println(dump);
	
	
	


}
 }
