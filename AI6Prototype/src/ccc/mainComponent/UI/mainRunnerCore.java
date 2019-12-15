package ccc.mainComponent.UI;

import ccc.interaction.global.addons.wSDotCamDownloader;
import ccc.interaction.global.addons.weatherMapThread;
import ccc.interaction.global.addons.weatherThread;
import ccc.interaction.global.database.DateAndTime;
import ccc.interaction.internalFeatures.Base64EncoderStatic;
import ccc.interaction.internalFeatures.alarmClock;
import ccc.interaction.global.notificationBox;
import ccc.interaction.global.popUpBox;
import ccc.interaction.global.popUpBoxNonStatic;
import ccc.mainComponent.CustomOutputDebugStream;
import ccc.mainComponent.Systems;
import ccc.mainComponent.calculatorOpr;
import ccc.mainComponent.experimental.DEBUG;
import dataInteractingAbility.ReadText;
import dataInteractingAbility.createFile;
import dataInteractingAbility.filesCore;
import dataInteractingAbility.writeText;
import ccc.mainComponent.globalID;
import ccc.mainComponent.UIComponents.mainRunnerCoreManager;
import ccc.mainComponent.UIComponents.restartApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import servicePackage.loadAI6Data;
import servicePackage.stabilizer;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

	@SuppressWarnings("serial")
	public class mainRunnerCore extends JFrame{
		 
		public JFrame frmAiProject;
	private JTextField textField;
	private static Systems systems;
	private static boolean startUP = true;
	public static JTextArea displayer;
	private String text;
	private Class<?> services;
	private Class<?> stabiliz;
	public Timer timer;
	private JPanel panel;
	private JPanel panel_1;
	private JCheckBox chckbxAutomaticNotification;
	private JCheckBox chckbxWindowOfficialPopup;
	private JLabel timeLabel;
	private JLabel DateLabel;
	public static JLabel weatherTemp;
	static weatherThread w;
	private JLabel lblWindspeed;
	private JLabel lblHumidity;
	private JLabel lblWC;
	private JLabel memoryPercent;
	public static JLabel weatherIcon;
	public static Image weatherImage = null;
	public static JLabel weatherM; 
	private JTextField setZipCode;
	private JLabel lblSetZipCode; private weatherMapThread wM;
	private boolean calRun = false;
  	private String storeSecNumber = "";
	 
  	private String userClass = "Admin";
  	
 	public mainRunnerCore() {
 		initializeComponent();
 		terminator = true;
 		
 		frmAiProject.setVisible(true);
 		systems = new Systems();
 		w = new weatherThread();
 		if(wM==null)
 		wM = new weatherMapThread();
 	    tcLoader();
 		clock();
 	}

 
 	private JTextArea DebugArea;
 
 	protected boolean terminator;
 	private JTextField textField_1;
 	private JLabel washingtonMapPicture;
	private JLabel weatherCon1;
	private JLabel temp1;
	private JLabel hum1;
	private JLabel winspeed1;
	private JPanel washingtonMap;
	public static JLabel spokaneWeatherIcon;
	public static JLabel seattleWeatherIcon;
	public static JLabel tacomaWeatherIcon;
 	public static JLabel ellensburgWeatherIcon;
 	private JButton numMinus;
	private JTextArea calDis;
	private boolean firstRun;
	private JLabel surPicture;
	private Thread tcload;
	private JList<String> cameraList;
	private JTextArea clientChatArea;
	private JProgressBar progressBarMain;
	private JTabbedPane tabbedPane;
	private JSlider mmDebug;
	private JCheckBox chckbxAttemptAutoRestart;
	private JCheckBox chckbxEnableMmDebug;
	static JCheckBox chckbxAllowCommand;
	private static JLabel clientIPAddress;
	private static JLabel firewallStatusClient;
	public static JLabel bellinghamWeather;
	public static JLabel mountVernonWeather;
	private Thread checkOvfl;
	private JLabel MUMpercent;
	public static JLabel lblControlcenterPanelV;
	private Thread alarm;
	protected int year;
	private DefaultListModel<String> alarmLists;
	private JList alarmList;
	private JLabel clock_alarmDayTXT;
	private JLabel clock_alarmMonthTXT;
  	private JSlider alarmClockhourSetting;
	private JSlider alarmClockminSetting;
	private JSlider alarmClocksecSetting;
	private JLabel clockAlarmHour;
	private JLabel clockAlarmMin;
	private JLabel cloclAlarmSecond;
	private JSlider clock_alarmDaySlider;
	private JCheckBox chckbxREPEATALARMCLOCK;
 
	public void initializeComponent() {
		frmAiProject = new JFrame();	
		frmAiProject.setResizable(false);
		frmAiProject.setTitle("AI6 Project");
		frmAiProject.setBounds(100, 100, 800, 480);
		frmAiProject.setDefaultCloseOperation(3);
		frmAiProject.getContentPane().setLayout(null);
	 
		frmAiProject.addWindowListener(new WindowAdapter(){
			private int logicLoader = 1;

			public void windowOpened(WindowEvent e) {
				if(logicLoader == 1) {
				 startUP();
				}else {
				 startUPOrigin();
				}
	   
			}

			private void startUPOrigin() {
			  Thread th = new Thread()
			   {
			    private boolean customStop1 = true;
			
				public void run() {
			    	while (customStop1) {
			    		
				     if (startUP) {
				      
				      globalID.addID(1.0D);
				      text = String.valueOf(globalID.getId()) + "System : loading all network and setting.";
				      disloader(text);
				
				
				      
				      globalID.addID(0.1D);
				      text = String.valueOf(globalID.getId()) + "System : loading inner network loader.";
				      try {
				       services = Class.forName("servicePackage.serviceLoader");
				      }
				      catch (ClassNotFoundException e1) {
				       e1.printStackTrace();
				      } 
				      
				      disloader(text);
				      
				      try { sleep(500L); } catch (InterruptedException e) { e.printStackTrace(); }
				      
				      if (services != null) {
				       globalID.addID(0.1D);
				       text = String.valueOf(globalID.getId()) + "System : loaded serviceLoader.";
				       
				       disloader(text);
				      } 
				
				
				      
				      globalID.addID(0.1D);
				      text = String.valueOf(globalID.getId()) + "System : loading default stabilizer.";
				      
				      disloader(text);
				      
				      try {
				       stabiliz = Class.forName("servicePackage.stabilizer");
				      } catch (ClassNotFoundException e1) {
				       e1.printStackTrace();
				      } 
				      if (stabiliz != null) {
				       if (stabilizer.getStabilizerValue()) {
				        globalID.addID(0.1D);
				        text = String.valueOf(globalID.getId()) + "System : loaded stabilizer.";
				        disloader(text);
				       } 
				      } else {
				       popUpBox.alertError("Couldn't load Stabilizer", "Core File Missing", true);
				      } 
				      
				      globalID.addID(0.1D);
				      text = String.valueOf(globalID.getId()) + "System : loaded all needed components.";
				      disloader(text);
				      
				      w.loadWeather();
			
			     }
				     customStop1 = false;
			
			     } 
			    }
			   };
			  
			  th.start();
			  checkIP(); //first Run
			  fireWallChecker(); //first Run
			 }
	 });
		

	tabbedPane = new JTabbedPane(1);
	tabbedPane.setBounds(10, 11, 761, 413);
	frmAiProject.getContentPane().add(tabbedPane);
 
 JPanel panel_8 = new JPanel();
 tabbedPane.addTab("Clock", null, panel_8, null);
 panel_8.setLayout(null);
 
 timeLabel = new JLabel("Clock Loading...");
 timeLabel.setBounds(37, 11, 660, 123);
 timeLabel.setFont(new Font("", 1, 100));
 panel_8.add(timeLabel);
 
 weatherTemp = new JLabel("Temperature : Loading");
 weatherTemp.setBounds(207, 269, 242, 14);
 panel_8.add(weatherTemp);
 
 lblWindspeed = new JLabel("Wind Speed : Loading");
 lblWindspeed.setBounds(207, 319, 224, 14);
 panel_8.add(lblWindspeed);
 
 lblHumidity = new JLabel("Humidity : Loading");
 lblHumidity.setBounds(207, 294, 160, 14);
 panel_8.add(lblHumidity);
 
 lblWC = new JLabel("Weather Condition Loading");
 lblWC.setBounds(207, 244, 345, 14);
 panel_8.add(lblWC);
 
 JSeparator separator = new JSeparator();
 separator.setBounds(20, 199, 684, 2);
 panel_8.add(separator);
 
 	DateLabel = new JLabel("DateError");
	DateLabel.setBounds(47, 93, 493, 123);
	DateLabel.setFont(new Font("", 1, 30));
	panel_8.add(DateLabel);
  
	  JLabel lblNewLabel = new JLabel("Weather Status");
	  lblNewLabel.setBounds(72, 345, 107, 14);
	  panel_8.add(lblNewLabel);
	  
	  weatherIcon = new JLabel();
	  weatherIcon.setBounds(37, 199, 160, 160);
	  panel_8.add(weatherIcon);
	  
	  JSeparator separator_2 = new JSeparator();
	  separator_2.setBounds(399, 212, 1, 162);
	  panel_8.add(separator_2);
	  
	  JPanel weatherMain = new JPanel();
	  tabbedPane.addTab("W.E.R.S.", null, weatherMain, null);
	  weatherMain.setLayout(null);
	  
	  JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
	  tabbedPane_4.setBounds(0, 0, 756, 385);
	  weatherMain.add(tabbedPane_4);
	  
	  JPanel weatherPanel = new JPanel();
	  tabbedPane_4.addTab("Main", null, weatherPanel, null);
	  weatherPanel.setLayout(null);
	  
	  weatherM = new JLabel();
	  weatherM.setBounds(10, 11, 218, 218);
	  weatherPanel.add(weatherM);
	  
	  weatherCon1 = new JLabel("Weather Condition Loading");
	  weatherCon1.setBounds(238, 44, 345, 14);
	  weatherPanel.add(weatherCon1);
	  
	  temp1 = new JLabel("Temperature : Loading");
	  temp1.setBounds(238, 69, 242, 14);
	  weatherPanel.add(temp1);
	  
	  hum1 = new JLabel("Humidity : Loading");
	  hum1.setBounds(238, 94, 160, 14);
	  weatherPanel.add(hum1);
	  
	  winspeed1 = new JLabel("Wind Speed : Loading");
	  winspeed1.setBounds(238, 119, 224, 14);
	  weatherPanel.add(winspeed1);
	  
	  washingtonMap = new JPanel();
	  tabbedPane_4.addTab("Washington Map", null, washingtonMap, null);
	  washingtonMap.setLayout(null);
	  
	  bellinghamWeather = new JLabel();
	  bellinghamWeather.setBounds(221, 0, 43, 43);
	  washingtonMap.add(bellinghamWeather);
	  
	  mountVernonWeather = new JLabel();
	  mountVernonWeather.setBounds(241, 34, 43, 43);
	  washingtonMap.add(mountVernonWeather);
	  
	  spokaneWeatherIcon = new JLabel();
	  spokaneWeatherIcon.setBounds(625, 91, 60, 56);
	  washingtonMap.add(spokaneWeatherIcon);
	  
	  seattleWeatherIcon = new JLabel();
	  seattleWeatherIcon.setBounds(208, 103, 43, 43);
	  washingtonMap.add(seattleWeatherIcon);
	  
	  tacomaWeatherIcon = new JLabel();
	  tacomaWeatherIcon.setBounds(194, 140, 42, 42);
	  washingtonMap.add(tacomaWeatherIcon);
	  
	  ellensburgWeatherIcon = new JLabel();
	  ellensburgWeatherIcon.setBounds(384, 150, 60, 56);
	  washingtonMap.add(ellensburgWeatherIcon);
	  
	  washingtonMapPicture = new JLabel();
	  washingtonMapPicture.setBounds(0, 0, 751, 357);
	  washingtonMap.add(washingtonMapPicture);
	  Image washingtonMapPic = Base64EncoderStatic.DecryptPicture(washington);
	  washingtonMapPic = washingtonMapPic.getScaledInstance(washingtonMapPicture.getWidth(), washingtonMapPicture.getHeight(), Image.SCALE_SMOOTH);
	  ImageIcon washingtonIcon = new ImageIcon(washingtonMapPic);
	  washingtonMapPicture.setIcon(washingtonIcon);
	  
	  JPanel surveillanceCameraPanel = new JPanel();
	  tabbedPane_4.addTab("WSDOT", null, surveillanceCameraPanel, null);
	  surveillanceCameraPanel.setLayout(null);
	  
	  surPicture = new JLabel("");
	  surPicture.setEnabled(true);
	  surPicture.setBounds(10, 11, 335, 335);
	  surveillanceCameraPanel.add(surPicture);
	  
	  cameraList = new JList<String>();
	  cameraList.addListSelectionListener(new ListSelectionListener() {
	  	public void valueChanged(ListSelectionEvent e) {
	  		int value = cameraList.getSelectedIndex();
		 	  wSDotCamDownloader.loadImage();
		 	  ImageIcon icon = new ImageIcon();
		 	  icon = wSDotCamDownloader.imageIcon.get(value);
		 	  surPicture.setIcon(icon);
	  	}
	  });
	  cameraList.setBounds(344, 11, 397, 335);
	  surveillanceCameraPanel.add(cameraList);
	  DefaultListModel<String> listModel = new DefaultListModel<String>();
		  listModel.addElement("I-90:Kittitas");
		  listModel.addElement("Manastash Ridge");
		  listModel.addElement("Ryegrass Summit");
		  listModel.addElement("I-90:MP107.5");
		  listModel.addElement("I-90:Thorp");
	  //}
	  
	  cameraList.setModel(listModel);;
	  cameraList.setSelectedIndex(0); //default
	  int randomClientID = (int) (Math.random()*250800);
	  String defaultUsnm = "default";
  
  panel = new JPanel();
  tabbedPane.addTab("Console", null, panel, null);
  panel.setLayout(null);
  JScrollPane scrollPane = new JScrollPane();
  scrollPane.setBounds(0, 0, 764, 341);
  panel.add(scrollPane);
  
  panel_1 = new JPanel();
  scrollPane.setViewportView(panel_1);
  panel_1.setLayout(null);
  
  JScrollPane scrollPane_5 = new JScrollPane();
  scrollPane_5.setBounds(0, 0, 752, 339);
  panel_1.add(scrollPane_5);
  
  displayer = new JTextArea(5, 30);
  scrollPane_5.setViewportView(displayer);
  displayer.setForeground(Color.BLACK);
  displayer.setBackground(Color.WHITE);
  displayer.setEditable(false);
  
  textField = new JTextField();
  textField.addKeyListener(new KeyAdapter()
    {
     public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == 10) {
       text = textField.getText();
       disloader(submitString(text));
      } 
      if (e.getKeyCode() == 38) {
       textField.setText(Systems.oldText);
      }
     }
    });
  textField.setBounds(10, 353, 599, 20);
  panel.add(textField);
  textField.setColumns(10);
  
    
    JButton btnNewButton = new JButton("Submit or Enter");
    btnNewButton.setBounds(619, 352, 129, 23);
    panel.add(btnNewButton);
    
      
      btnNewButton.addKeyListener(new KeyAdapter()
        {
         public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == 10) {
           text = textField.getText();
           textField.setText("");
           SwingWorker<Void, Void> submitter = new SwingWorker<Void, Void>()
            {
             protected Void doInBackground() throws Exception
             {
             
              return null;
             }
            };
    
    
           
           submitter.execute();
          } 
         }
        });
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
          text = textField.getText();
          textField.setText("");
          SwingWorker<Void, Void> submitter = new SwingWorker<Void, Void>()
           {
            protected Void doInBackground() throws Exception
            {
             
             return null;
            }
           };
          
          submitter.execute();
         }
        });
      textField.requestFocusInWindow();
  
  JPanel COM = new JPanel();
  tabbedPane.addTab("C.O.M.", null, COM, null);
  COM.setLayout(null);
  
  JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
  tabbedPane_2.setBounds(0, 0, 756, 385);
  COM.add(tabbedPane_2);
  
  JPanel panel_3 = new JPanel();
  tabbedPane_2.addTab("Client", null, panel_3, null);
  panel_3.setLayout(null);
  
  clientChatMsg = new JTextField();
  clientChatMsg.setBounds(10, 326, 582, 20);
  panel_3.add(clientChatMsg);
  clientChatMsg.setColumns(10);
  
  JButton btnSend = new JButton("Send");
  btnSend.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
		  	if((!clientChatMsg.getText().contains(":")) && !clientChatMsg.equals("") && cIsConnected == true) {
		  		try {
		  			if(clientChatMsg.getText().contains("/") && userClass.equals("Admin")) {
		  				cWriter.println("[" + cUsername + "] : " + clientChatMsg.getText() + ":Command");
		  				cWriter.flush();
		  			}else if (clientChatMsg.getText().contains("/") && !userClass.equals("Admin")){
		  				popUpBox.alertError("You have no permission.", "Socket Security");
		  			}else if (!clientChatMsg.getText().contains("/") && !userClass.equals("Admin")){
		  				cWriter.println("[" + cUsername + "] :" + clientChatMsg.getText() + ":Chat");
		  				cWriter.flush();
		  			}else if (!clientChatMsg.getText().contains("/") && userClass.equals("Admin")){
		  				cWriter.println("[" + cUsername + "] :" + clientChatMsg.getText() + ":Chat");
		  				cWriter.flush();
		  			}
		  			
		  		}catch (Exception ex){
		  			
		  		}
		  	}else if((!clientChatMsg.getText().contains(":")) && !clientChatMsg.equals("") && cIsConnected == false){
		  		popUpBox.warningBox("Please connect to the server to send message.", "Socket Warning :");
		  	}else {
		  		popUpBox.alertError("Illegal message detected", "Socket Security :");
		  	}
		  	clientChatArea.setCaretPosition(clientChatArea.getDocument().getLength());
  	}
  });
  btnSend.setBounds(602, 325, 139, 23);
  panel_3.add(btnSend);
  
  JScrollPane scrollPane_1 = new JScrollPane();
  scrollPane_1.setBounds(10, 11, 731, 304);
  panel_3.add(scrollPane_1);
  
  clientChatArea = new JTextArea();
  scrollPane_1.setViewportView(clientChatArea);
  
  JPanel COMcontrolPanel = new JPanel();
  tabbedPane_2.addTab("Control Panel", null, COMcontrolPanel, null);
  COMcontrolPanel.setLayout(null);
  
  clientUsername = new JTextField();
  clientUsername.setBounds(194, 67, 161, 20);
  COMcontrolPanel.add(clientUsername);
  clientUsername.setText(defaultUsnm+randomClientID);
  clientUsername.setColumns(10);
  
  JLabel lblCleintUsername = new JLabel("Cleint Username : ");
  lblCleintUsername.setBounds(49, 70, 175, 14);
  COMcontrolPanel.add(lblCleintUsername);
  
  JButton btnJoinServer = new JButton("Join Server");
  btnJoinServer.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		
  		try(final DatagramSocket socket = new DatagramSocket()){
  		  cAddress = InetAddress.getLocalHost().getHostAddress();
  		} catch (SocketException | UnknownHostException e2) {
				e2.printStackTrace();
			}
  		
  		if(cIsConnected == false) {
  			cUsername = clientUsername.getText();
  			if(cUsername.equals("")) {
  				popUpBox.warningBox("Please enter your username.", "Socket Warning : ");
  			}else {
		  			ipPort = Integer.valueOf(clientIpPort.getText());
		  			clientUsername.setEditable(false);
		  			
		  			try {
		  				clientIPAddress.setText(InetAddress.getLocalHost().getHostAddress());
			  			clientSocket = new Socket(cAddress,Integer.valueOf(clientIpPort.getText()));
			  			InputStreamReader stream = new InputStreamReader(clientSocket.getInputStream());
		  			cReader = new BufferedReader(stream);
		  			cWriter = new PrintWriter(clientSocket.getOutputStream());
		  			clientChatArea.setText("");
		  			cWriter.println("(Join) " + "[" + userClass + "] " + cUsername + ":has connected.:Connect");
		  			cWriter.flush();
		  			cIsConnected = true;
		  			}catch(Exception ex) {
			  			popUpBox.alertError("Couldn't connect to the server.", "Socket Server Error :");
			  			clientUsername.setEditable(true);
			  		}
		  			ListenThread();
  			}
  		}else if(cIsConnected == true){
  			clientChatArea.append("Already connected.");
  		}
  		
  		
  		
  		
  	}

  });
  btnJoinServer.setBounds(437, 30, 183, 23);
  COMcontrolPanel.add(btnJoinServer);
  
  JLabel clientIPPort = new JLabel("IP Port :");
  clientIPPort.setBounds(49, 105, 145, 14);
  COMcontrolPanel.add(clientIPPort);
  
  clientIpPort = new JTextField();
  clientIpPort.setText("0001");
  clientIpPort.setColumns(10);
  clientIpPort.setBounds(194, 102, 161, 20);
  COMcontrolPanel.add(clientIpPort);
  
  JButton button = new JButton("Disconnect Server");
  button.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String message = ("[" + cUsername +"]" + " : :Disconnect");
  		try {
  			cWriter.println(message);
  			cWriter.flush();
  		}catch(Exception ex){
  			ex.printStackTrace();
  		}
  	}
  });
  button.setBounds(437, 64, 183, 23);
  COMcontrolPanel.add(button);
  
  JLabel lblClientPanel = new JLabel("Client Panel :");
  lblClientPanel.setBounds(23, 33, 214, 14);
  COMcontrolPanel.add(lblClientPanel);
  
  clientIPAddress = new JLabel("Error-IP-Not-Found");
  clientIPAddress.setBounds(194, 145, 161, 14);
  COMcontrolPanel.add(clientIPAddress);
  
  JLabel lblIpAddress = new JLabel("IP Address :");
  lblIpAddress.setBounds(49, 145, 145, 14);
  COMcontrolPanel.add(lblIpAddress);
  
  JLabel lblFirewallBlock = new JLabel("Firewall Block :");
  lblFirewallBlock.setBounds(49, 170, 145, 14);
  COMcontrolPanel.add(lblFirewallBlock);
  
  firewallStatusClient = new JLabel("Positively None (Clear)");
  firewallStatusClient.setBounds(194, 170, 233, 14);
  COMcontrolPanel.add(firewallStatusClient);
  
  JLabel lblPleaseNote = new JLabel("Please Note : If it didn't work, please check your device firewall.");
  lblPleaseNote.setBounds(10, 326, 533, 20);
  COMcontrolPanel.add(lblPleaseNote);
  
  JLabel lblControlpanelVersion = new JLabel("ControlPanel Version 1.0 - R2");
  lblControlpanelVersion.setBounds(553, 329, 225, 14);
  COMcontrolPanel.add(lblControlpanelVersion);
  
  JLabel clientnotice = new JLabel("Client Version 1.0-B3-Release01 - Support Standard server version 1.1 to lastest.");
  clientnotice.setBounds(10, 312, 515, 14);
  COMcontrolPanel.add(clientnotice);
  
  JPanel serverStarter = new JPanel();
  tabbedPane_2.addTab("Server", null, serverStarter, null);
  serverStarter.setLayout(null);
  
  JLabel lblIpPortConfiguration = new JLabel("IP Port Configuration : ");
  lblIpPortConfiguration.setBounds(26, 62, 153, 14);
  serverStarter.add(lblIpPortConfiguration);
  
  JLabel lblServerConfiguration = new JLabel("Server Configuration");
  lblServerConfiguration.setBounds(10, 11, 191, 14);
  serverStarter.add(lblServerConfiguration);
  
  JSeparator separator_5 = new JSeparator();
  separator_5.setBounds(9, 29, 459, 8);
  serverStarter.add(separator_5);
  
  serverCOMipPortConfig = new JTextField();
  serverCOMipPortConfig.setBounds(171, 59, 205, 20);
  serverStarter.add(serverCOMipPortConfig);
  serverCOMipPortConfig.setColumns(10);
  
  JButton btnStartCustomServer = new JButton("Start Custom Server");
  btnStartCustomServer.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		serverModule window = new serverModule();
		window.frmServerVersion.setVisible(true);
  	}
  });
  btnStartCustomServer.setBounds(528, 58, 166, 23);
  serverStarter.add(btnStartCustomServer);
  
  JLabel lblDefaultPortIs = new JLabel("Note : Default port is 0001, If port setting is empty.");
  lblDefaultPortIs.setBounds(26, 100, 350, 14);
  serverStarter.add(lblDefaultPortIs);
  
  JLabel lblServerPanelVersion = new JLabel("Server Panel Version 1.1");
  lblServerPanelVersion.setBounds(546, 332, 195, 14);
  serverStarter.add(lblServerPanelVersion);
  
  chckbxAllowCommand = new JCheckBox("Allow Remote Command [Master Overwrite]");
  chckbxAllowCommand.setBounds(26, 194, 350, 23);
  serverStarter.add(chckbxAllowCommand);
  
  JSeparator separator_6 = new JSeparator();
  separator_6.setBounds(9, 183, 459, 2);
  serverStarter.add(separator_6);
  
  JLabel lblServerAllowance = new JLabel("Server Setting :");
  lblServerAllowance.setBounds(10, 163, 158, 14);
  serverStarter.add(lblServerAllowance);
  
  JLabel lblMaxUser = new JLabel("Max User :");
  lblMaxUser.setBounds(26, 277, 82, 14);
  serverStarter.add(lblMaxUser);
  
  textField_2 = new JTextField();
  textField_2.setEditable(false);
  textField_2.setBounds(118, 274, 37, 20);
  serverStarter.add(textField_2);
  textField_2.setColumns(10);
  
  JLabel maximumJoin = new JLabel("/100");
  maximumJoin.setBounds(160, 277, 48, 14);
  serverStarter.add(maximumJoin);
  
  JSeparator separator_7 = new JSeparator();
  separator_7.setBounds(10, 264, 458, 2);
  serverStarter.add(separator_7);
  
  JLabel lblNewLabel_2 = new JLabel("Server Property :");
  lblNewLabel_2.setBounds(10, 244, 122, 14);
  serverStarter.add(lblNewLabel_2);
  
  JLabel lblcomingSoon = new JLabel("(Coming soon)");
  lblcomingSoon.setBounds(200, 277, 103, 14);
  serverStarter.add(lblcomingSoon);
  
  JPanel appspanel = new JPanel();
  tabbedPane.addTab("Apps", null, appspanel, null);
  appspanel.setLayout(null);
  
  JTabbedPane appstab = new JTabbedPane(JTabbedPane.TOP);
  appstab.setBounds(0, 0, 756, 398);
  appspanel.add(appstab);
  
  JPanel Calculator = new JPanel();
  appstab.addTab("Calculator", null, Calculator, null);
  Calculator.setLayout(null);
  
  JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
  tabbedPane_1.setBorder(null);
  tabbedPane_1.setBounds(0, 0, 751, 370);
  Calculator.add(tabbedPane_1);
  
  JPanel defaultCal = new JPanel();
  tabbedPane_1.addTab("Default", null, defaultCal, null);
  defaultCal.setLayout(null);
  
  JButton numReset = new JButton("Reset");
  numReset.setBackground(Color.LIGHT_GRAY);
  numReset.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = null;
  		calDis.setText(numberEnter);
  		calculatorOpr.firstNum=0;
  		calculatorOpr.secondNum=0;
  		calculatorOpr.operator=null;
  	}
  });
  numReset.setFont(new Font("Tahoma", Font.BOLD, 11));
  numReset.setBounds(330, 22, 70, 47);
  defaultCal.add(numReset);
  
  JButton numDevide = new JButton("/");
  numDevide.setBackground(Color.LIGHT_GRAY);
  numDevide.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(calRun==false) {
  			calculatorOpr.firstNum = Double.parseDouble(calDis.getText());
  			calDis.setText(calDis.getText()+"\noperator : /\n");
  			calculatorOpr.operator = "/";
  			calRun = true;
  		}else {
  			calculate();
  			
  		}
  	
  	}
	
  });
  numDevide.setFont(new Font("Tahoma", Font.BOLD, 16));
  numDevide.setBounds(410, 22, 70, 47);
  defaultCal.add(numDevide);
  
  JButton numMul = new JButton("*");
  numMul.setBackground(Color.LIGHT_GRAY);
  numMul.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(calRun==false) {
  			calculatorOpr.firstNum = Double.parseDouble(calDis.getText());
  			calDis.setText(calDis.getText()+"\noperator : *\n");
  			calculatorOpr.operator = "*";
  			calRun = true;
  		}else {
  			calculate();
  			
  		}
  	}
  });
  numMul.setFont(new Font("Tahoma", Font.BOLD, 16));
  numMul.setBounds(490, 22, 70, 47);
  defaultCal.add(numMul);
  
  numMinus = new JButton("-");
  numMinus.setBackground(Color.LIGHT_GRAY);
  numMinus.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(calRun==false) {
  			calculatorOpr.firstNum = Double.parseDouble(calDis.getText());
  			calDis.setText(calDis.getText()+"\noperator : -\n");
  			calculatorOpr.operator = "-";
  			calRun = true;
  		}else {
  			calculate();
  			
  		}
  	}
  });
  numMinus.setFont(new Font("Tahoma", Font.BOLD, 24));
  numMinus.setBounds(570, 22, 70, 75);
  defaultCal.add(numMinus);
  
  JButton num7 = new JButton("7");
  num7.setBackground(Color.LIGHT_GRAY);
  num7.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 7;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "7";
  	}
  });
  num7.setFont(new Font("Tahoma", Font.BOLD, 16));
  num7.setBounds(330, 80, 70, 47);
  defaultCal.add(num7);
  
  JButton num8 = new JButton("8");
  num8.setBackground(Color.LIGHT_GRAY);
  num8.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 8;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "8";
  	}
  });
  num8.setFont(new Font("Tahoma", Font.BOLD, 16));
  num8.setBounds(410, 80, 70, 47);
  defaultCal.add(num8);
  
  JButton num9 = new JButton("9");
  num9.setBackground(Color.LIGHT_GRAY);
  num9.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 9;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "9";
  	}
  });
  num9.setFont(new Font("Tahoma", Font.BOLD, 16));
  num9.setBounds(490, 80, 70, 47);
  defaultCal.add(num9);
  
  JButton numPlus = new JButton("+");
  numPlus.setBackground(Color.LIGHT_GRAY);
  numPlus.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(calRun==false) {
  			calculatorOpr.firstNum = Double.parseDouble(calDis.getText());
  			calDis.setText(calDis.getText()+"\noperator : +\n");
  			calculatorOpr.operator = "+";
  			calRun = true;
  		}else {
  			calculate();
  			
  		}
  	}
  });
  numPlus.setFont(new Font("Tahoma", Font.BOLD, 16));
  numPlus.setBounds(570, 110, 70, 75);
  defaultCal.add(numPlus);
  
  JButton num4 = new JButton("4");
  num4.setBackground(Color.LIGHT_GRAY);
  num4.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 4;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "4";
  	}
  });
  num4.setFont(new Font("Tahoma", Font.BOLD, 16));
  num4.setBounds(330, 138, 70, 47);
  defaultCal.add(num4);
  
  JButton num5 = new JButton("5");
  num5.setBackground(Color.LIGHT_GRAY);
  num5.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 5;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "5";
  	}
  });
  num5.setFont(new Font("Tahoma", Font.BOLD, 16));
  num5.setBounds(410, 138, 70, 47);
  defaultCal.add(num5);
  
  JButton num6 = new JButton("6");
  num6.setBackground(Color.LIGHT_GRAY);
  num6.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 6;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "6";
  	}
  });
  num6.setFont(new Font("Tahoma", Font.BOLD, 16));
  num6.setBounds(490, 138, 70, 47);
  defaultCal.add(num6);
  
  JButton Confirm = new JButton("E");
  Confirm.setBackground(Color.LIGHT_GRAY);
  Confirm.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		calculate();
  	}
  });
  Confirm.setFont(new Font("Tahoma", Font.BOLD, 16));
  Confirm.setBounds(570, 196, 70, 105);
  defaultCal.add(Confirm);
  
  JButton num1 = new JButton("1");
  num1.setBackground(Color.LIGHT_GRAY);
  num1.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 1;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "1";
  	}
  });
  num1.setFont(new Font("Tahoma", Font.BOLD, 16));
  num1.setBounds(330, 196, 70, 47);
  defaultCal.add(num1);
  
  JButton num2 = new JButton("2");
  num2.setBackground(Color.LIGHT_GRAY);
  num2.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 2;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "2";
  	}
  });
  num2.setFont(new Font("Tahoma", Font.BOLD, 16));
  num2.setBounds(410, 196, 70, 47);
  defaultCal.add(num2);
  
  JButton num3 = new JButton("3");
  num3.setBackground(Color.LIGHT_GRAY);
  num3.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 3;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "3";
  	}
  });
  num3.setFont(new Font("Tahoma", Font.BOLD, 16));
  num3.setBounds(490, 196, 70, 47);
  defaultCal.add(num3);
  
  JButton num0 = new JButton("0");
  num0.setBackground(Color.LIGHT_GRAY);
  num0.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + 0;
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += "0";
  	}
  });
  num0.setFont(new Font("Tahoma", Font.BOLD, 16));
  num0.setBounds(330, 254, 150, 47);
  defaultCal.add(num0);
  
  JButton numDot = new JButton(".");
  numDot.setBackground(Color.LIGHT_GRAY);
  numDot.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		String numberEnter = calDis.getText() + ".";
  		calDis.setText(numberEnter);
  		if(calRun==true)
  		storeSecNumber += ".";
  	}
  });
  numDot.setFont(new Font("Tahoma", Font.BOLD, 16));
  numDot.setBounds(490, 254, 70, 47);
  defaultCal.add(numDot);
  
  calDis = new JTextArea();
  calDis.setEditable(false);
  calDis.setFont(new Font("Monospaced", Font.PLAIN, 42));
  calDis.setBounds(10, 11, 310, 320);
  defaultCal.add(calDis);
  
  JButton numReverse = new JButton("�");
  numReverse.setBackground(Color.LIGHT_GRAY);
  numReverse.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		double holder = Double.parseDouble(String.valueOf(calDis.getText()));
  		holder = -1 * holder;
  		calDis.setText(String.valueOf(holder));
  	}
  });
  numReverse.setFont(new Font("Tahoma", Font.BOLD, 24));
  numReverse.setBounds(650, 22, 70, 75);
  defaultCal.add(numReverse);
  
  JLabel lblNewLabel_1 = new JLabel("Calculator Version 1.7");
  lblNewLabel_1.setBounds(580, 317, 201, 14);
  defaultCal.add(lblNewLabel_1);
  
  JPanel clockPanel = new JPanel();
  appstab.addTab("Clock", null, clockPanel, null);
  clockPanel.setLayout(null);
  
  JTabbedPane cP_alarm = new JTabbedPane(JTabbedPane.TOP);
  cP_alarm.setBounds(0, 0, 751, 359);
  clockPanel.add(cP_alarm);
  
  JPanel clock_alarmPanel = new JPanel();
  cP_alarm.addTab("Alarm", null, clock_alarmPanel, null);
  clock_alarmPanel.setLayout(null);
  
  alarmList = new JList();
  alarmList.setBounds(10, 11, 313, 309);
  clock_alarmPanel.add(alarmList);
  alarmLists = new DefaultListModel<String>();
//}

  alarmList.setModel(alarmLists);
  
  clock_alarmDaySlider = new JSlider();
  clock_alarmDaySlider.setValue(1);
  clock_alarmDaySlider.setMinimum(1);
  clock_alarmDaySlider.setMaximum(31);
  clock_alarmDaySlider.setBounds(417, 24, 200, 26);
  clock_alarmPanel.add(clock_alarmDaySlider);
  clock_alarmDaySlider.addChangeListener(new ChangeListener() {
  	public void stateChanged(ChangeEvent e) {
  		clock_alarmDayTXT.setText(clock_alarmDaySlider.getValue()+"");
  	}
  });

  
  JLabel clock_alarmtxtDay = new JLabel("Day : ");
  clock_alarmtxtDay.setBounds(360, 24, 65, 26);
  clock_alarmPanel.add(clock_alarmtxtDay);
  
  JLabel clock_alarmtxtMonth = new JLabel("Month : ");
  clock_alarmtxtMonth.setBounds(360, 71, 65, 26);
  clock_alarmPanel.add(clock_alarmtxtMonth);
  
  JSlider clock_alarmMonthSlider = new JSlider();
  clock_alarmMonthSlider.setValue(1);
  clock_alarmMonthSlider.setMinimum(1);
  clock_alarmMonthSlider.setMaximum(12);
  clock_alarmMonthSlider.setBounds(417, 71, 200, 26);
  clock_alarmPanel.add(clock_alarmMonthSlider);
  clock_alarmMonthSlider.addChangeListener(new ChangeListener() {
  	public void stateChanged(ChangeEvent e) {
  		clock_alarmMonthTXT.setText(clock_alarmMonthSlider.getValue()+"");
  	}
  });

  
  JLabel clock_alarmtxtYear = new JLabel("Year :");
  clock_alarmtxtYear.setBounds(360, 120, 65, 26);
  clock_alarmPanel.add(clock_alarmtxtYear);  clock_alarmYear = new JTextField();
  clock_alarmYear.setBounds(417, 123, 65, 20);
  clock_alarmPanel.add(clock_alarmYear);
  
  	JButton btnAddTime = new JButton("Add Alarm");
  	btnAddTime.addActionListener(new ActionListener() {


		public void actionPerformed(ActionEvent e) {
	  		
	  		alarmClock.alarm = new ArrayList<String>();
	  		
	  		File locate = null;
			try {
				locate = new File(filesCore.getDir());
			} catch (URISyntaxException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			try {
				String repeatStat = "";
				if(chckbxREPEATALARMCLOCK.isSelected()) {
					repeatStat = "Repeat";
				}else {
					repeatStat = "noRepeat";
				}
				
				writeText.addText("alarm="  + clock_alarmMonthSlider.getValue() + ":" + clock_alarmDaySlider.getValue() +  ":" + clock_alarmYear.getText() + ":" +
						alarmClockhourSetting.getValue() + ":" + alarmClockminSetting.getValue() + ":" + alarmClocksecSetting.getValue() + ":"  + repeatStat
						, locate.getParentFile()+"\\AI6CoreFolder\\AI6Data.txt" , "[Alarm]=");
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				
			}
	  	refresh();
	  	
	  	//Thread holdRefresh = new Thread(holdRefresh());
	  	//holdRefresh.start();
		String data = ReadText.loadAllText(locate.getParentFile()+"\\AI6CoreFolder\\AI6Data.txt");
		loadAI6Data.refresh(data);
		updateAlarmClockList();
	  	}
  	});
  	

  btnAddTime.setBounds(360, 297, 122, 23);
  clock_alarmPanel.add(btnAddTime);
  
  clock_alarmDayTXT = new JLabel("1");
  clock_alarmDayTXT.setBounds(635, 30, 48, 14);
  clock_alarmPanel.add(clock_alarmDayTXT);
  
  clock_alarmMonthTXT = new JLabel("1");
  clock_alarmMonthTXT.setBounds(635, 77, 48, 14);
  clock_alarmPanel.add(clock_alarmMonthTXT);
  
  JButton removeAlarm = new JButton("Remove Alarm");
  removeAlarm.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		
  		File locate = null;
		try {
			locate = new File(filesCore.getDir());
		} catch (URISyntaxException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		//String alarmTarget = (String) alarmList.getSelectedValue();
		//String alarmTarget = alarmClock.alarm.get(alarmList.getSelectedIndex()).toString();
		int store = alarmList.getSelectedIndex();
		String alarmTarget = "alarm=" + alarmClock.alarm.get(store);
		//DEBUG.print(alarmTarget);
		try {
			writeText.removeText(locate.getParentFile()+"\\AI6CoreFolder\\AI6Data.txt",alarmTarget.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
  		
  		alarmClock.alarm = new ArrayList<String>();
  		
  		refresh();
  		
		String data = ReadText.loadAllText(locate.getParentFile()+"\\AI6CoreFolder\\AI6Data.txt");
		loadAI6Data.refresh(data);
		updateAlarmClockList();
  	}
  });
  removeAlarm.setBounds(492, 297, 122, 23);
  clock_alarmPanel.add(removeAlarm);
  
  alarmClockhourSetting = new JSlider();
  alarmClockhourSetting.setValue(0);
  alarmClockhourSetting.setMaximum(23);
  alarmClockhourSetting.setBounds(417, 169, 200, 26);
  clock_alarmPanel.add(alarmClockhourSetting);
  alarmClockhourSetting.addChangeListener(new ChangeListener() {
	  
  	public void stateChanged(ChangeEvent e) {
  		clockAlarmHour.setText(alarmClockhourSetting.getValue()+"");
  	}
  });

  
  JLabel HourTXTalarmClock = new JLabel("Hour :");
  HourTXTalarmClock.setBounds(360, 169, 65, 26);
  clock_alarmPanel.add(HourTXTalarmClock);
  
  JLabel lblMinTXT = new JLabel("Min :");
  lblMinTXT.setBounds(360, 206, 65, 26);
  clock_alarmPanel.add(lblMinTXT);
  
  alarmClockminSetting = new JSlider();
  alarmClockminSetting.setValue(0);
  alarmClockminSetting.setMaximum(59);
  alarmClockminSetting.setBounds(417, 206, 200, 26);
  clock_alarmPanel.add(alarmClockminSetting);
  alarmClockminSetting.addChangeListener(new ChangeListener() {
  	public void stateChanged(ChangeEvent e) {
  		clockAlarmMin.setText(alarmClockminSetting.getValue()+"");
  	}
  });

  
  JLabel lblSecondTXT = new JLabel("Second :");
  lblSecondTXT.setBounds(360, 243, 65, 26);
  clock_alarmPanel.add(lblSecondTXT);
  
  alarmClocksecSetting = new JSlider();
  alarmClocksecSetting.setValue(0);
  alarmClocksecSetting.setMaximum(59);
  alarmClocksecSetting.setBounds(417, 243, 200, 26);
  clock_alarmPanel.add(alarmClocksecSetting);
  alarmClocksecSetting.addChangeListener(new ChangeListener() {
  	public void stateChanged(ChangeEvent e) {
  		cloclAlarmSecond.setText(alarmClocksecSetting.getValue()+"");
  	}
  });

  
  clockAlarmHour = new JLabel("0");
  clockAlarmHour.setBounds(635, 175, 48, 14);
  clock_alarmPanel.add(clockAlarmHour);
  
  clockAlarmMin = new JLabel("0");
  clockAlarmMin.setBounds(635, 212, 48, 14);
  clock_alarmPanel.add(clockAlarmMin);
  
  cloclAlarmSecond = new JLabel("0");
  cloclAlarmSecond.setBounds(635, 249, 48, 14);
  clock_alarmPanel.add(cloclAlarmSecond);
  
  chckbxREPEATALARMCLOCK = new JCheckBox("Repeat");
  chckbxREPEATALARMCLOCK.setBounds(501, 122, 97, 23);
  clock_alarmPanel.add(chckbxREPEATALARMCLOCK);

  JPanel panel_6 = new JPanel();
  tabbedPane.addTab("Setting", null, panel_6, null);
  panel_6.setLayout(null);
  
  JTabbedPane tabbedPane_3 = new JTabbedPane(1);
  tabbedPane_3.setBounds(0, 0, 756, 385);
  panel_6.add(tabbedPane_3);
  
  JPanel panel_9 = new JPanel();
  tabbedPane_3.addTab("Notification", null, panel_9, null);
  panel_9.setLayout(null);
  
  chckbxAutomaticNotification = new JCheckBox("Automatic Notification");
  chckbxAutomaticNotification.setBounds(6, 36, 230, 23);
  panel_9.add(chckbxAutomaticNotification);
  
  JLabel lblDidntConsumeAny = new JLabel("Didn't consume any CPU. Must be enabled to use others.");
  lblDidntConsumeAny.setBounds(16, 59, 345, 14);
  panel_9.add(lblDidntConsumeAny);
  
  chckbxWindowOfficialPopup = new JCheckBox("Window Official Pop-Up");
  chckbxWindowOfficialPopup.setBounds(381, 36, 252, 23);
  panel_9.add(chckbxWindowOfficialPopup);
  
  JLabel lblWarningThisWill = new JLabel("Warning, this will consume some CPU and can't be turn off.");
  lblWarningThisWill.setBounds(391, 59, 345, 14);
  panel_9.add(lblWarningThisWill);
  
  JLabel lblKernelSetting = new JLabel("Kernel Setting");
  lblKernelSetting.setBounds(6, 11, 303, 14);
  panel_9.add(lblKernelSetting);
  
  JSeparator separator_1 = new JSeparator();
  separator_1.setBounds(6, 25, 701, 2);
  panel_9.add(separator_1);
  
  JPanel panel_10 = new JPanel();
  tabbedPane_3.addTab("Weather", null, panel_10, null);
  panel_10.setLayout(null);
  
  lblSetZipCode = new JLabel("Set Zip Code :");
  lblSetZipCode.setBounds(10, 11, 121, 14);
  panel_10.add(lblSetZipCode);
  
  setZipCode = new JTextField();
  setZipCode.setBounds(20, 36, 184, 20);
  panel_10.add(setZipCode);
  setZipCode.setColumns(10);
  
  JButton btnSetZip = new JButton("Submit");
  btnSetZip.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
      w.zipChanger(setZipCode.getText());
      textField_1.setText(weatherThread.zip);
     }
    });

  
  btnSetZip.setBounds(223, 35, 89, 23);
  panel_10.add(btnSetZip);
  
  textField_1 = new JTextField();
  textField_1.setText("98926");
  textField_1.setEditable(false);
  textField_1.setColumns(10);
  textField_1.setBounds(356, 36, 125, 20);
  panel_10.add(textField_1);
  
  JLabel lblCurrentZipCode = new JLabel("Current Zip Code :");
  lblCurrentZipCode.setBounds(356, 11, 191, 14);
  panel_10.add(lblCurrentZipCode);
  
  final JCheckBox chckbxReportWeather = new JCheckBox("Report Weather (When it updates)");
  chckbxReportWeather.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
      if (chckbxReportWeather.isSelected()) {
       weatherThread.reportEnable = true;
      } else {
       weatherThread.reportEnable = false;
      } 
     }
    });
  chckbxReportWeather.setBounds(10, 116, 350, 23);
  panel_10.add(chckbxReportWeather);
  
  JLabel lblWNotificationPanel = new JLabel("Notification Panel :");
  lblWNotificationPanel.setBounds(10, 95, 151, 14);
  panel_10.add(lblWNotificationPanel);
  
  JSeparator separator_3 = new JSeparator();
  separator_3.setBounds(10, 74, 731, 2);
  panel_10.add(separator_3);
  
  JSeparator separator_4 = new JSeparator();
  separator_4.setBounds(10, 157, 731, 2);
  panel_10.add(separator_4);
  
  JPanel stP = new JPanel();
  tabbedPane_3.addTab("Local Stabilizer", null, stP, null);
  stP.setLayout(null);
  
  chckbxAttemptAutoRestart = new JCheckBox("Attempt auto restart when memory usage exceed limit.");
  chckbxAttemptAutoRestart.setSelected(true);
  chckbxAttemptAutoRestart.setBounds(21, 265, 497, 23);
  stP.add(chckbxAttemptAutoRestart);
  
  JSeparator separator_8 = new JSeparator();
  separator_8.setBounds(10, 231, 531, 2);
  stP.add(separator_8);
  
  JLabel lblMemoryUsage = new JLabel("Debug Memory Usage : [Version 1.1]");
  lblMemoryUsage.setBounds(10, 213, 332, 14);
  stP.add(lblMemoryUsage);
  
  JLabel lblMaxMemory = new JLabel("Max memory : ");
  lblMaxMemory.setBounds(26, 244, 100, 14);
  stP.add(lblMaxMemory);
  
  mmDebug = new JSlider();
  mmDebug.setValue(95);
  mmDebug.addChangeListener(new ChangeListener() {
	  
  	public void stateChanged(ChangeEvent e) {
  		try {
  			MUMpercent.setText(mmDebug.getValue() + "%");
  		}catch(NullPointerException ex1) {}
  	}
  });
  mmDebug.setMinimum(25);
  mmDebug.setBounds(121, 239, 200, 26);
  stP.add(mmDebug);
  
  chckbxEnableMmDebug = new JCheckBox("Enable MU Debug");
  chckbxEnableMmDebug.setSelected(true);
  chckbxEnableMmDebug.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(checkOvfl!=null) {
  			memoryPercent.setText("STOPPED");
  			DEBUG.print("DEBUG : Shutting down MU.");
  		}else {
  			checkOvfl = new Thread(new checkMU()) {
  			};
  			checkOvfl.start();
  		}
  		
  	}
  });
  chckbxEnableMmDebug.setBounds(21, 291, 265, 23);
  stP.add(chckbxEnableMmDebug);
  
  JLabel lblStabilizerPanelVersion = new JLabel("Stabilizer Panel version 1.0");
  lblStabilizerPanelVersion.setBounds(575, 343, 176, 14);
  stP.add(lblStabilizerPanelVersion);
  
  MUMpercent = new JLabel("95%");
  MUMpercent.setBounds(351, 244, 48, 14);
  stP.add(MUMpercent);
  chckbxWindowOfficialPopup.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
      notificationBox n = new notificationBox(Class.class, false);
      n.loadTray();
     }
    });
  chckbxAutomaticNotification.addActionListener(new ActionListener()
    {
     public void actionPerformed(ActionEvent e) {}
    });

  
  JPanel panel_7 = new JPanel();
  tabbedPane.addTab("Debug", null, panel_7, null);
  panel_7.setLayout(null);
  
  JScrollPane scrollPane_6 = new JScrollPane();
  scrollPane_6.setBounds(10, 11, 736, 313);
  panel_7.add(scrollPane_6);
  
  DebugArea = new JTextArea();
  scrollPane_6.setViewportView(DebugArea);
  PrintStream printStream = new PrintStream(new CustomOutputDebugStream(DebugArea));
  System.setOut(printStream);
  System.setErr(printStream);
  
  JLabel lblDebuggerPrototype = new JLabel("DEBUGGER Prototype 1.2");
  lblDebuggerPrototype.setBounds(573, 360, 150, 14);
  panel_7.add(lblDebuggerPrototype);
  
  JLabel lblYouCanUse = new JLabel("You can use this window to collect any error logs and debug.");
  lblYouCanUse.setBounds(10, 360, 368, 14);
  panel_7.add(lblYouCanUse);
  
  JLabel lblNewLabel_3 = new JLabel("Local Memory :");
  lblNewLabel_3.setBounds(573, 335, 114, 14);
  panel_7.add(lblNewLabel_3);
  
  memoryPercent = new JLabel("null");
  memoryPercent.setBounds(685, 335, 71, 14);
  panel_7.add(memoryPercent);
  
  lblControlcenterPanelV = new JLabel("Control Center Panel V.1.0");
  lblControlcenterPanelV.setBounds(560, 426, 234, 14);
  frmAiProject.getContentPane().add(lblControlcenterPanelV);
  
  progressBarMain = new JProgressBar();
  progressBarMain.setBounds(10, 426, 540, 14);
  progressBarMain.setMaximum(10);
  frmAiProject.getContentPane().add(progressBarMain);

	}
	
	/*protected Runnable holdRefresh() {
		boolean customStopHR = true;
		while(customStopHR  == true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customStopHR = false;
			
		}
		loadAI6Data.load();
		return null;
	}*/

	protected void refresh() {
		writeText.upload1();

	}

	private void calculate() {
		calRun = false;
		if(storeSecNumber.equals("") && stabilizer.getASValue()==true) { //patch 1.5
			storeSecNumber = "0";
			popUpBoxNonStatic nonPop = new popUpBoxNonStatic();
			nonPop.alertError("Empty String Exception - Second Value is null.", "Calculator Alert", true);
		}
		calculatorOpr.secondNum = Double.parseDouble(String.valueOf(storeSecNumber));
		storeSecNumber = ""; //patch 1.5&1.6 empty String - back to null
		calculatorOpr.calculate();
		calDis.setText(calculatorOpr.answer);
	}
	
	private void startDateAndTime() {
		Thread date = new Thread() {
			public void run() {
				DateAndTime.setLocalDaT();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		date.run();
	    
	}
 private void startUP() {
  Thread th = new Thread()
   {
    private boolean customStop1 = true;
    private int cP = 0;
    private long startUp = 250;
	private boolean folderCreated = false;
	public void run() {
    	while (customStop1) {
    		
	     if (startUP) {

	    	 for(cP = -1; cP<12; cP++) {
	    	    if(cP==0){
	   	    	 tabbedPane.setSelectedIndex(2);
	    	 	}else if(cP==1) {
	    			 globalID.addID(1.0D);
	    			 tabbedPane.setSelectedIndex(2);
	    		      text = String.valueOf(globalID.getId()) + "System : loading all network and setting.";
	    		      disloader(text);	
	    		      progressBarMain.setValue(progressBarMain.getValue()+1);
	    		}else if(cP==2) {
	    			 globalID.addID(0.1D);
	    			 tabbedPane.setSelectedIndex(2);
	    		      text = String.valueOf(globalID.getId()) + "System : loading inner network loader.";
	    		      try {
	    		       services = Class.forName("servicePackage.serviceLoader");
	    		      }
	    		      catch (ClassNotFoundException e1) {
	    		       e1.printStackTrace();
	    		      } 
	    		      progressBarMain.setValue(progressBarMain.getValue()+1);
	    		      disloader(text);
	    		}else if(cP==3) {
	    			tabbedPane.setSelectedIndex(2);
	    		      if (services != null) {
	    			       globalID.addID(0.1D);
	    			       text = String.valueOf(globalID.getId()) + "System : loaded serviceLoader.";
	    			       progressBarMain.setValue(progressBarMain.getValue()+1);
	    			       disloader(text);
	    			      } 	
	    		}else if(cP==4) {
	    		      globalID.addID(0.1D);
	    		      tabbedPane.setSelectedIndex(2);
	    		      text = String.valueOf(globalID.getId()) + "System : loading default stabilizer.";
	    		      progressBarMain.setValue(progressBarMain.getValue()+1);
	    		      disloader(text);
	    		      try {
	    			       stabiliz = Class.forName("servicePackage.stabilizer");
	    			      } catch (ClassNotFoundException e1) {
	    			       e1.printStackTrace();
	    			      } 
	    			      if (stabiliz != null) {
	    			       if (stabilizer.getStabilizerValue()) {
	    			        globalID.addID(0.1D);
	    			        text = String.valueOf(globalID.getId()) + "System : loaded stabilizer.";
	    			        progressBarMain.setValue(progressBarMain.getValue()+1);
	    			        disloader(text);
	    			       } 
	    			      } else {
	    			       popUpBox.alertError("Couldn't load Stabilizer", "Core File Missing", true);
	    			      }      
	    		}else if(cP==5) {
	    			tabbedPane.setSelectedIndex(2);
	    			checkOvfl = new Thread(new checkMU()) {
	    			};
	    			checkOvfl.start();
	    		  globalID.addID(0.1D);
	    		  DateAndTime.setPattern("yyyy/MM/dd HH:mm:ss");
	    		  
	    		  startDateAndTime();
	    		  clock_alarmYear.setColumns(10);
	    		  clock_alarmYear.setText(year+"");
   			      text = String.valueOf(globalID.getId()) + "System : loaded all needed components.";
   			      progressBarMain.setValue(progressBarMain.getValue()+1);
   			      disloader(text);
	    		}else if (cP ==6) {
	    			 globalID.addID(0.1D);
	    			 tabbedPane.setSelectedIndex(2);
	    			text = String.valueOf(globalID.getId()) + "System : loaded weatherModule.";
	   			      progressBarMain.setValue(progressBarMain.getValue()+1);
	   			      disloader(text);
	   			   SwingWorker<Void, Void> submitter = new SwingWorker<Void, Void>()
	               {
	                

					protected Void doInBackground() throws Exception
	                {
						
	                w.loadWeather();
	  	    		  
	                 return null;
	                }
	               };
	       
	       
	              
	              submitter.execute();
	              
	     
	               
		    	 }else if (cP ==7) {
		    		globalID.addID(0.1D);
		    		tabbedPane.setSelectedIndex(2);
	    			text = String.valueOf(globalID.getId()) + "System : loaded weatherMapModule.";
	    			startweatherM();
	    			progressBarMain.setValue(progressBarMain.getValue()+1);
	   			    disloader(text);
		    	 }else if (cP ==8) {
		    		 tabbedPane.setSelectedIndex(2);
		    		globalID.addID(0.1D);
		    		text = String.valueOf(globalID.getId()) + "System : Welcome to AI6 Prototype 1.2.";
		    		SwingWorker<Void, Void> submitter = new SwingWorker<Void, Void>()
		               {
		                protected Void doInBackground() throws Exception
		                {
		                	//soundBoard s = new soundBoard();
		                	//s.readLineDefaultExpr("welcome to A I6 Prototype 1.2.");
		                 return null;
		                }
		               };
		              submitter.execute();
		    		startweatherM();
		    		progressBarMain.setValue(progressBarMain.getValue()+1);
		   			disloader(text);
		   			
		   			try {Thread.sleep(1500);} 
		    		catch (InterruptedException e) {e.printStackTrace();}
		    	 
		    	 }else if (cP ==9) {
		    		 globalID.addID(0.1D);
		    		 tabbedPane.setSelectedIndex(2);
		    		 
		    		 File folderCreation = null;
					try {
						folderCreation = new File(filesCore.getDir());
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
		    		 folderCreation = folderCreation.getParentFile();
		    		 File fileName = null;
		    		 try {
		    			 fileName = new File(filesCore.getDir());
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		 

		    		 
		    		// filename = new java.io.File(mainRunnerCore.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName();
		    		String filename = fileName.getName(); 
		    		// try {
		    			 //System.out.println(filesCore.getDir());
						 //System.out.println(folderCreation.getAbsolutePath()+"\\AI6CoreFolder\\"+fileName);
					//} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					//}
		    		 File isExisted = new File(folderCreation.getAbsolutePath()+"\\AI6CoreFolder");
		    		 System.out.println(isExisted.getAbsolutePath());
		    		 try {
						//if(filesCore.getDir().equals(folderCreation.getAbsolutePath()+"\\AI6CoreFile\\"+filename)&&folderCreated == false){
						if(isExisted.exists()&&!filesCore.getDir().contains("AI6CoreFolder")) {	
							//move core to folder
							//shortcut
							displayer.append("\n" + globalID.getId() + "Configuring and loading library for AI6.");
							folderCreated = true;
						}else if(isExisted.exists()&&!filesCore.getDir().contains("AI6CoreFolder")) {
							if(folderCreated == false) {
								displayer.append("\n" + globalID.getId() + "Loading library for AI6.");
								folderCreated = true;
							}
						}else if(filesCore.getDir().equals(folderCreation.getAbsolutePath()+"\\"+filename)&&filesCore.getDir().contains("AI6CoreFolder")) {
							if(folderCreated == false) {
								displayer.append("\n" + globalID.getId() + "Loading local library for AI6.");
								folderCreated = true;
							}
						}else{
							createFile.createFolder(folderCreation.getAbsolutePath(), "AI6CoreFolder");
							displayer.append("\n" + globalID.getId() + "Creating library for AI6.");
						}
						

			               
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
		    		 loadAI6Data.load();
		    		 
		    		//////////////////////////////////////
		 			File locate = null;
					try {
						locate = new File(filesCore.getDir());
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					text = String.valueOf(globalID.getId()) + "System : updating data.";
					disloader(text);
					writeText.update(locate.getParentFile()+"\\AI6CoreFolder\\AI6DataTemp.txt", locate.getParentFile()+"\\AI6CoreFolder\\AI6Data.txt");
		    		//////////////////////////////////////
					updateAlarmClockList();
					//////////////////////////////////////
					text = String.valueOf(globalID.getId()) + "System : loaded all components.";
		   			 progressBarMain.setValue(progressBarMain.getValue()+1);
		   			 disloader(text);
		   			 startUp = 1000;
		    	 }else if (cP ==10) {
		    		 	globalID.addID(0.1);
		    		 	tabbedPane.setSelectedIndex(2);
						SwingWorker<Void, Void> alarmClockActivate = new SwingWorker<Void, Void>()
			               {
			                

							protected Void doInBackground() throws Exception
			                {
								
								alarm = new Thread(new alarmClock());
					    		alarm.run();
			  	    		  
			                 return null;
			                }
			               };
			    		  
			            alarmClockActivate.execute();
			            
			           // clock_alarmDaySlider.setValue(Integer.valueOf(DateAndTime.getDAT().split("/")[3]));
			            
			            text = String.valueOf(globalID.getId()) + "System : loaded all apps modules";
				   		disloader(text);
	    		}else if (cP ==11) {
		    		 tabbedPane.setSelectedIndex(0);
		    		 startUP = false;
		    		 progressBarMain.setValue(0);
	    		}

	  	      try {
	  			
				Thread.sleep(startUp);
	  		} catch (InterruptedException e) {
	  			e.printStackTrace();
	  		}
	  	      
	    	 }    
	      
	      

     }
	     customStop1 = false;

     } 
    }
   };
  
  th.start();
  checkIP(); //first Run
  fireWallChecker(); //first Run
 }

 	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void updateAlarmClockList() {
 		alarmLists.removeAllElements();
		alarmLists = new DefaultListModel<String>();
		
	  		for(int c = 0; c<alarmClock.getAlarm().size(); c++) {
	  			alarmLists.addElement(alarmClock.getAlarm().get(c));	
	  		}
	  	alarmList.setModel(alarmLists);
	}

public class checkMU implements Runnable{

	private boolean debugMU;

	@Override
	public void run() {
		debugMU = chckbxEnableMmDebug.isSelected()==true ? true : false;
		
		while(debugMU) {
		   debugMU = chckbxEnableMmDebug.isSelected()==true ? true : false;
	       long memoryleft = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	       long maxMemory = Runtime.getRuntime().totalMemory();
	       String long1 = memoryleft+"";
	       String long2 = maxMemory+"";
	       double longT1 = Integer.valueOf(long1);
	       double longT2 = Integer.valueOf(long2);
	       int calcule = (int) Math.round((longT1/longT2)*100);
	       memoryPercent.setText((calcule) + "%");
	       
	       if(chckbxAttemptAutoRestart.isSelected())
	       if((calcule > mmDebug.getValue()) == true) {
	    	   popUpBox.alertError("Protection System." + "\n[Memory Leak Detection] Java memory over limit." + "\n[System] : Restarting/shutting down program...","");
	    	   new restartApplication();
	       }
	       
		       try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		memoryPercent.setText("STOPPED");
		DEBUG.print("DEBUG : MU Stopped.");
		checkOvfl = null;
	}
	 
 }

 	private String submitString(String text) {
 		if (text.equals("")) {
 			text = "<empty>";
 		}
 		textField.setText("");
 		return systems.submitString(text);
 	}
 
 private void disloader(String input) {
  if (Double.valueOf(globalID.getpureId()) != 0.0D) {
   displayer.setText(String.valueOf(displayer.getText()) + "\n" + input);
  } else {
   displayer.setText(input);
  } 
 }

 
 public void startweatherM() {
	 if(firstRun == false) {
		 Thread weatherM = new Thread() {
	 
		 public void run() {

			 wM.loadWeatherM();
		 }
 			};
 			weatherM.start();
 			firstRun = true;
	 }
 }
 
 private void clock() {
  Thread clock = new Thread()
    {

	public void run()
     {
      try {
       while (terminator) {
       weatherTemp.setText("Temperature = " + w.temperature + "�F");
       temp1.setText("Temperature = " + w.temperature + "�F");
        lblWindspeed.setText("Wind Speed = " + w.windSpeed + " mph.");
        winspeed1.setText("Wind Speed = " + w.windSpeed + " mph.");
        lblHumidity.setText("Humidity : " + w.humidity + " %");
        hum1.setText("Humidity : " + w.humidity + " %");
        
        if (w.weatherCon != null) {
        	lblWC.setText("Weather Prediction : " + w.weatherCon);
        	weatherCon1.setText("Weather Prediction : " + w.weatherCon);
        }else{
        	lblWC.setText("Weather Condition : \nOffline");
        } 
        
        Calendar cal = new GregorianCalendar();
        int day = cal.get(5);
        
        int month = cal.get(2);
        year = cal.get(1);
        
        String date = "unknown date";
        String[] strDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        
        date = strDays[cal.get(7) - 1];
        
        int second = cal.get(13);
        int min = cal.get(12);
        int hour = cal.get(10);
        
        int amPm = cal.get(9);
        
        String seconds = (new StringBuilder(String.valueOf(second))).toString();
        String minutes = (new StringBuilder(String.valueOf(min))).toString();
        if (second < 10) {
         seconds = "0" + second;
        }
        
        if (min < 10) {
         minutes = "0" + min;
        }
        
        String amStatus = "";
        if (amPm == 0) {
         amStatus = "AM";
        } else {
         amStatus = "PM";
        } 
       
       timeLabel.setText(String.valueOf(hour) + ":" + minutes + ":" + seconds + amStatus);
       DateLabel.setText(String.valueOf(date) + " : " + month + "/" + day + "/" + year);
       
       DebugArea.setCaretPosition(DebugArea.getDocument().getLength());
       
      ///////////////////////////////
       DateAndTime.setLocalDaT();
      // DEBUG.print(DateAndTime.getDAT());
       //DateAndTime.setDate(day, month, year, hour, min, second);
 	  
      //////////////////////////////
       //repaint();
       Thread.sleep(1000);
       
       @SuppressWarnings("unused")
	String str = "https://samples.openweathermap.org/data/2.5/weather?zip=98926,us&appid=e307d664165be8b427a7b806f37245e8";
      } 
     } catch (Exception exception) {}
    }
   };


  
  clock.run();
 }
 
 private void tcLoader() {
	 tcload = new Thread() {
		 public void run() {
			while(terminator) {
				  int value = cameraList.getSelectedIndex();
			 	  wSDotCamDownloader.loadImage();
			 	  ImageIcon icon = new ImageIcon();
			 	  try {
			 		 icon = wSDotCamDownloader.imageIcon.get(value); 
			 	  }catch (ArrayIndexOutOfBoundsException ex) {
			 	  }
			 	  
			 	  //System.out.println("Debug : Refreshing cam picture 01");
			 	  surPicture.setIcon(icon);
			 	 // System.out.print(Thread.NORM_PRIORITY);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

		 }
		
	 };

	 tcload.start();
 }
 
 private String cUsername = "default"; 
 private String cAddress = "localhost";
 private ArrayList<String> cUsers = new ArrayList<String>();
 private Socket clientSocket;
 private BufferedReader cReader;
 private PrintWriter cWriter;
 
 @SuppressWarnings("unused")
private int ipPort = 0001;
 private boolean cIsConnected = false;
 private JTextField clientUsername;
 private JTextField clientIpPort;
 private JTextField clientChatMsg;
 static JTextField serverCOMipPortConfig;
 private JTextField textField_2;
 private static Socket fwChecker;
 private JTextField clock_alarmYear;
 
 public void ListenThread() {
	 Thread IncomingReader = new Thread (new IncomingReader());
		DEBUG.print("DEBUG : Started Client."); 
	 	IncomingReader.start();
 }
 
 	public static void checkIP() {
 		try {
			clientIPAddress.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			DEBUG.print("Couldn't find IP Address");
		}
 	}
	public static void fireWallChecker(){
 		try {
 			fwChecker = new Socket("stackoverflow.com",80);	
 		}catch(IOException e){
 			firewallStatusClient.setText("Highly Possible Blocked");
 		}
 	}
 public class IncomingReader implements Runnable {

	@Override
	public void run() {
		String[] data;
		String stream;
		try {
			while ((stream = cReader.readLine()) != null) {
				data = stream.split(":");
				
				if(data[2].equals("Chat")) {
					clientChatArea.append(data[0] + ": " + data[1] + "\n");
					clientChatArea.setCaretPosition(clientChatArea.getDocument().getLength());
				}if(data[2].equals("Command")) {
					clientChatArea.append(data[0] + ": " + data[1] + "\n");
					clientChatArea.setCaretPosition(clientChatArea.getDocument().getLength());
					 globalID.addID(1.0D);
					displayer.append("\n" + globalID.getId() +"Remote Command execute : " + data[1]);
					 globalID.addID(1.0D);
					 String usernameC = data[0].substring(1,data[0].length()-2);
					 if(!usernameC.equals(clientUsername.getText())) {
						 disloader(submitString(rCommandFilter(data[1].substring(1))));
						 System.out.println(rCommandFilter(data[1].substring(1)));
					 }
					
				}else if(data[2].equals("Connect")) {
					clientChatArea.removeAll();
					cUserAdd(data[0]);
				}else if(data[2].equals("Disconnect")) {
					cUserRemove(data[0]);
				}else if(data[2].equals("Done")) {
					cWriteUsers();
					cUsers.clear();
				}else if(data[2].equals("ForceDisconect")) {
					if(data[1].equals(clientUsername.getText())) {
						fwChecker.close();
					}
					
					//developing...
				}
				
			}
		}catch(Exception ex) {
			
		}
	}

	private String rCommandFilter(String substring) {
		if(substring.equals("/test")) {
			substring = "test";
		}else {}
		return substring;
	}

	private void cWriteUsers() {
		String[] tempList = new String[(cUsers.size())];
		cUsers.toArray(tempList);
		
	}

	private void cUserRemove(String string) {
		clientChatArea.append(string + "is now offline.\n");
		
	}

	private void cUserAdd(String string) {
		cUsers.add(string);
	}
	 

 }
}


