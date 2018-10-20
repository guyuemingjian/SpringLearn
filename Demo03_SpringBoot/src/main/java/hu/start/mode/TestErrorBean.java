package hu.start.mode;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component("tB")
public class TestErrorBean {
	
	@Min(value=16, message="id小于16了")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
