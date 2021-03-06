package com.matrimony.vo.enums;

import java.io.Serializable;

public enum OptionsEnum implements Serializable {
	/*YES("Yes"), NO("No"), NO_ANSWER("No Answer");*/
	YES("Y"), NO("N"), NO_ANSWER("NA")/*, KETU("केतू")*/;

	private String option;

	private OptionsEnum(String option) {
		this.option = option;
	}

	public String getOption() {
		return this.option;
	}

	public static OptionsEnum getOption(String opt) {
		for (OptionsEnum options : OptionsEnum.values()) {
			if (options.getOption().equalsIgnoreCase(opt)) {
				return options;
			}
		}
		// default return
		return OptionsEnum.NO_ANSWER;
	}

	public static OptionsEnum[] toOptionsEnumArray(String[] optionsCodes) {
		if (optionsCodes == null || optionsCodes.length == 0) {
			return new OptionsEnum[0];
		}
		// if not null and not empty
		int length = optionsCodes.length;
		OptionsEnum[] result = new OptionsEnum[length];
		for (int idx = 0; idx < length; idx++) {
			result[idx] = OptionsEnum.getOption(optionsCodes[idx]);
		}
		return result;
	}

	public static String[] toStringArray(OptionsEnum[] optionsArray) {
		if (optionsArray == null || optionsArray.length == 0) {
			return new String[0];
		}
		// if not null and not empty
		int length = optionsArray.length;
		String[] result = new String[length];
		for (int idx = 0; idx < length; idx++) {
			result[idx] = (optionsArray[idx] == null) ? OptionsEnum.NO_ANSWER.getOption() : optionsArray[idx]
					.getOption();
		}
		return result;
	}

}
