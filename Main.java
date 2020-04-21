package cly.work08.demo01;
//����һ���ַ��������ж��Ƿ��������֤����Ҫ�󣬲����ؾ��������yyyy-mm-dd��
//��������������������0000-00-00������Ҫ���ǣ�
//a)������18λ��b) ǰ��λ�����������֣����һλ���������ֻ�Сд��ĸ��c) �����Ǵ��ڵġ�


import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sr = new Scanner(System.in);
		//System.out.println("Input Your ID Number");
		String num = sr.next();
		try {
			System.out.println(checkString(num));
		} catch (WrongDateException e) {
			// TODO: handle exception
			System.out.println("0000-00-00");
		}catch (ParseException e) {
			// TODO: handle exception
			System.out.println("0000-00-00");
		}
	}
	// ������֤���֤�ŵķ���
	public static String checkString(String str) throws WrongDateException, ParseException {
		StringBuffer strb = new StringBuffer(str);
		// ���ж��Ƿ�����18λ
		if (strb.length() != 18) {
			return "0000-00-00";
		}
//		�ж����һλ�����ֻ�Сд��ĸ,ǰ17λ������
		if ((strb.charAt(17) >= 48 && strb.charAt(17) <= 57) || (strb.charAt(17) >= 97 && strb.charAt(17) <= 122)) {
			for (int i = 0; i < 17; i++) {
				if (strb.charAt(i) > 57 || strb.charAt(i) < 48) {
					return "0000-00-00";
				}
			}
		}else {
			return "0000-00-00";
		}
		// ��ȡ8λ����Ϊyyyy-mm-dd��ʽ
		String dateString = MessageFormat.format("{0}-{1}-{2}", strb.substring(6, 10), strb.substring(10, 12),
				strb.substring(12, 14));
		//�ж�������ֵ�Ƿ�Ϸ�
		int yyyy = Integer.parseInt(dateString.substring(0, 4));
		int mm = Integer.parseInt(dateString.substring(5, 7));
		int dd = Integer.parseInt(dateString.substring(8, 10));
		if(yyyy>=1800) {
		switch (mm) {
		case 1:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate1");
			}
			break;
		case 2:
			if (yyyy%4 == 0) {
				if(dd==0 || dd>= 30) {throw new WrongDateException("WrongDate2.1");}
			}else {
				if (dd==0 || dd>=29) {throw new WrongDateException("WrongDate2.2");}
			}
			break;
		case 3:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate3");
			}
			break;
		case 4:
			if (dd==0 || dd>=31) {
				throw new WrongDateException("WrongDate4");
			}
			break;
		case 5:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate5");
			}
			break;
		case 6:
			if (dd==0 || dd>=31) {
				throw new WrongDateException("WrongDate6");
			}
			break;
		case 7:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate7");
			}
			break;
		case 8:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate8");
			}
			break;
		case 9:
			if (dd==0 || dd>=31) {
				throw new WrongDateException("WrongDate9");
			}
			break;
		case 10:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate10");
			}
			break;
		case 11:
			if (dd==0 || dd>=31) {
				throw new WrongDateException("WrongDate11");
			}
			break;
		case 12:
			if (dd==0 || dd>=32) {
				throw new WrongDateException("WrongDate12");
			}
			break;
		default:
			break;
		}}else {throw new WrongDateException("WrongDateYYYY");}
		
		
		// ת��ΪDate���ж������Ƿ�����ϵͳ��ǰʱ��
		if (getRiqi(dateString).compareTo(new Date()) > 0) {
			throw new WrongDateException("ErrorLater");
		}
		
		return dateString;
	}

//����getRiqi�ķ������������ַ���ת��ΪDate����
	public static Date getRiqi(String str) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date date = df.parse(str);
		return date;
	}

}

class WrongDateException extends Exception {
	public WrongDateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public WrongDateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
