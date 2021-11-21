package com.ztt.api.dto.user;

import com.ztt.api.constants.PatterConstant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserAddDto {
    @NotBlank(message = "用户昵称不能为空")
    @Length(min = 4,max = 16,message = "用户昵称长度4~16")
    private String userName;
    @NotBlank(message = "密码不能为空")
    @Length(min = 16,max = 16,message = "用户密码长度16位")
    private String userPsw;
    @Pattern(regexp = PatterConstant.PHONE_PATTERN,message = "号码无效")
    private String phone;
}
