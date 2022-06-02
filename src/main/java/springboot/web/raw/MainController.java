package springboot.web.raw;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.web.raw.models.Concert;
import springboot.web.raw.models.Program;
import springboot.web.raw.models.Root;
import springboot.web.raw.models.Work;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

	static Root root = null;
	int count_ = 0;
	int a=0;
	ArrayList<Concert> let = new ArrayList<Concert>(); //concert with season
	Set<String> ret = new HashSet<>();
	Set<String> s = new HashSet<String>(); //venues played by composer
	Set<String> le = new HashSet<>();


	{
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		File file = new File("D:\\Users\\vsuresh\\Desktop\\largefile-jackson\\raw_nyc\\src\\main\\resources\\raw_nyc_phil.json");
		root = objectMapper.readValue(file, Root.class);
	}
	MainController() throws IOException {
	}

	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);


		return "register_form";
	}

	@PostMapping("/register_")
	public String submitForm(@ModelAttribute("user") User user) {

		//number of program id greater than the given program id
		count_ = (int) root.programs.stream().filter(x->x.programID>user.getNumber_of_programID_greater_than()).count();

		//location at which the season took place
		for (Program p : root.programs) {
			if (user.getConcerts_of_the_season().equals(p.season)) {
				//System.out.println("done");
				for (Concert c : p.concerts) {

					le.add(c.location);
				}
				//System.out.println(id+" "+p.season);
			}
		}


		//displays composer worked under the work id
		for (Program p : root.programs){
			for (Work w : p.works){
				if(user.getConcerts_of_workID().equals(w.iD))
				{
					ret.add(w.composerName) ;
					break;
				}
				//System.out.println(id+" "+p.season);
			}
		}

		//venues_at_the_composer_performed
		for (Program p : root.programs){
			for (Work w : p.works){
				if(w.composerName!= null && w.composerName.contains(user.getVenues_at_the_composer_performed())) {
					for (Concert c : p.concerts) {
						s.add(c.venue);
					}
					break;
				}
			}

		}

		user.setCount(count_);
		user.setRet(ret);
		user.setSconcert(le);
		user.setVenues(s);

		System.out.println("count: "+count_);
		System.out.println("ret: "+ret);
		System.out.println("let: "+le);
		System.out.println("Venue"+s);

		//System.out.println("prog input: " +user.getNumber_of_programID_greater_than());
		//System.out.println("ret op: "user.getRet());
		//System.out.println(user.getSconcert() );
		//System.out.println(user.getVenues());

		return "register_success";
	}

	}
