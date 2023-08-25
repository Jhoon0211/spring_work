package aaa.model;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class KemData {

	@Pattern(regexp="[가-힣]{2,5}", message="한글 2~5입니다.")
	String pname;
	
	@Min(value = 1, message = "1 이상의 값을 입력해주세요.")
	@Max(value = 100, message = "100 이하의 값을 입력해주세요.")
	String kor;

	@Min(value = 1, message = "1 이상의 값을 입력해주세요.")
	@Max(value = 100, message = "100 이하의 값을 입력해주세요.")
	String eng;

	@Min(value = 1, message = "1 이상의 값을 입력해주세요.")
	@Max(value = 100, message = "100 이하의 값을 입력해주세요.")
	String mat;
}
