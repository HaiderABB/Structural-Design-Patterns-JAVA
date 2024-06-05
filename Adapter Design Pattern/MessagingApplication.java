interface MessagingService {
  void sendMessage(String message);

  String receiveMessage();
}

interface SMSService {
  void sendSMS(String phoneNumber, String message);

  String receiveSMS();
}

interface EmailService {
  void sendEmail(String emailAddress, String message);

  String receiveEmail();
}

// Adapter for SMS service
class SMSAdapter implements MessagingService {
  private SMSService smsService;

  public SMSAdapter(SMSService smsService) {
    this.smsService = smsService;
  }

  @Override
  public void sendMessage(String message) {
    smsService.sendSMS("defaultPhoneNumber", message);
  }

  @Override
  public String receiveMessage() {
    return smsService.receiveSMS();
  }
}

class EmailAdapter implements MessagingService {
  private EmailService emailService;

  public EmailAdapter(EmailService emailService) {
    this.emailService = emailService;
  }

  @Override
  public void sendMessage(String message) {
    emailService.sendEmail("defaultEmailAddress", message);
  }

  @Override
  public String receiveMessage() {
    return emailService.receiveEmail();
  }
}

class SMSServiceImpl implements SMSService {
  @Override
  public void sendSMS(String phoneNumber, String message) {
  }

  @Override
  public String receiveSMS() {
    return "SMS testing received";
  }
}

class EmailServiceImpl implements EmailService {
  @Override
  public void sendEmail(String emailAddress, String message) {
  }

  @Override
  public String receiveEmail() {
    return "Email testing received";
  }
}

public class MessagingApplication {
  public static void main(String[] args) {
    // Using SMS service
    SMSService smsService = new SMSServiceImpl();
    MessagingService smsAdapter = new SMSAdapter(smsService);
    smsAdapter.sendMessage("SMS Testing");
    System.out.println(smsAdapter.receiveMessage());

    // Using Email service
    EmailService emailService = new EmailServiceImpl();
    MessagingService emailAdapter = new EmailAdapter(emailService);
    emailAdapter.sendMessage("Email Testing");
    System.out.println(emailAdapter.receiveMessage());
  }
}