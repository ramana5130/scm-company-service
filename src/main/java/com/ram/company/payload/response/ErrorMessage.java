package com.ram.company.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private String dateTime;
	private String message;
	private int status;
	private String code;

}
