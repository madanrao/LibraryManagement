package com.utd.library;

import java.awt.EventQueue;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class UTDLibrary extends JFrame {
	SQLData sd = new SQLData();
	ResultSet rs;
	
	//panels
	JPanel zero = new JPanel();
	JPanel one = new JPanel();
	JPanel two = new JPanel();
	JPanel three = new JPanel();
	JPanel four = new JPanel();
	JPanel five = new JPanel();
	JPanel six=new JPanel();
	JPanel seven = new JPanel();
	JPanel eight = new JPanel();
	JPanel nine = new JPanel();
	JPanel ten = new JPanel();
	
	CardLayout card = new CardLayout();
	JOptionPane popup = new JOptionPane();
	//text fields 
	JTextField bookIdText;
	 JTextField bookTitleText;
	 JTextField authorText;
	
	JTable searchBookTable = new JTable();
	JTable checkingBookTable=new JTable();
	JTable booksDueWeek = new JTable();	
	JScrollPane scroll = new JScrollPane();
	JScrollPane scroller = new JScrollPane();
	JScrollPane tablescroll = new JScrollPane();
	JScrollPane scrollPane = new JScrollPane();
	
	
	int searchBookRowNum = 0;
	String bookIDToBorrow;
    String bookTitleToBorrow;
    String bookAuthorToBorrow;
	String noOfCopies;
	String availableCopies;
    String branchIDToBorrowFrom;
    
    String fName;
    String lName;
    String address;
    String phone;
    String bookIDToAdd;
    String titleToAdd;
    String authorNameToAdd;
    String typeToAdd;
    String branchIDToAdd;
    String copiesToAdd;
    
    

	private JTextField bookIDToBorrowText;
	private JTextField titleToBorrowText;
	private JTextField authorToBorrowText;
	private JTextField branchIDToBorrowText;
	private JTextField noOfCopiesToBorrowText;
	private JTextField remCopiesToBorrowText;
	private JTextField cardNumberText;

	BookSearch controller = new BookSearch();
	CheckOut checkOut = new CheckOut();
	CheckIn checkIn = new CheckIn();
	Fines fine = new Fines();
	Displayer d = new Displayer();
	AddBook book=new AddBook();
	Login login = new Login();
	BooksDue due = new BooksDue();
	//Borrower Details
	BorrowerDetails borrower = new BorrowerDetails();
	private boolean showBorrowerButton = false;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;
	private JTextField textPhoneNo;
	int newInsertedCardNumber;
	private JTextField bookIDCheckInText;
	private JTextField cardNoCheckInText;
	private JTextField firstNameCheckInText;
	private JTextField lastNameCheckInText;
	 
	String loan_id;
	String book_id;
	String cardNumberCheckIn;
	private JTable table;
	private JTextField txtEnterCardNo;
	private JTextField txtEnterName;
	private JLabel lblNewLabelFines;
	private JTextField textBookID;
	private JTextField textTitle;
	private JTextField textAuthorName;
	private JTextField textType;
	private JTextField textBranchID;
	private JTextField textCopies;
	private JTextField textUserName;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private JTextField textEnterUsername;
	private JPasswordField EnterPasswordField;
	private JTextField txtEnterLoanId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UTDLibrary frame = new UTDLibrary();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UTDLibrary() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		JPanel parent = new JPanel(); // create the Parent Panel
		getContentPane().add(parent); // add the base Parent panel to JFrame
		parent.setLayout(card); // Add CardLayout to the parent JPanel... sort of like adding a lever to the Parent. When you use card.show, it alternates its children
		
		
		
		//PANEL ZERO
		parent.add(zero,"0");
		zero.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Dallas Public Library");
		lblWelcomeToThe.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 15));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(26, 58, 355, 14);
		zero.add(lblWelcomeToThe);
		
		
		
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(48, 113, 113, 20);
		zero.add(lblUsername);
		
		textUserName = new JTextField();
		textUserName.setBounds(184, 110, 167, 20);
		zero.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(48, 154, 86, 14);
		zero.add(lblPassword);
		
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm Password :");
		lblConfirmPassword_1.setBounds(48, 197, 113, 14);
		zero.add(lblConfirmPassword_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 151, 167, 20);
		zero.add(passwordField);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(184, 194, 167, 20);
		zero.add(passwordConfirm);
		
		textEnterUsername = new JTextField();
		textEnterUsername.setBounds(184, 342, 167, 20);
		zero.add(textEnterUsername);
		textEnterUsername.setColumns(10);
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setBounds(48, 345, 113, 14);
		zero.add(lblEnterUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password: ");
		lblEnterPassword.setBounds(48, 389, 113, 14);
		zero.add(lblEnterPassword);
		
		EnterPasswordField = new JPasswordField();
		EnterPasswordField.setBounds(184, 386, 167, 20);
		zero.add(EnterPasswordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageDigest md;
				try {
					if(!(new String(passwordField.getPassword()).equals(new String(passwordConfirm.getPassword()))))
					    	popup.showMessageDialog(null, "Passwords don't match.",null,JOptionPane.ERROR_MESSAGE);		
					else{
					md = MessageDigest.getInstance("SHA-256");
					md.update(new String(passwordField.getPassword()).getBytes());//md has password in bytes
			        String hashed = new String(md.digest());  // encryption
			        int n = login.insertUser(textUserName.getText(),hashed);
			        System.out.println(hashed);
			        if(n==1)
			        	popup.showMessageDialog(null, "User Created. Please login.");
			        else
			        	popup.showMessageDialog(null, "Error occurred. Please try again.",null,JOptionPane.ERROR_MESSAGE);
					}
					} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		
		btnSignUp.setBounds(184, 247, 89, 23);
		zero.add(btnSignUp);
		final JPanel fnl = parent;
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(184, 428, 89, 23);
		zero.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					MessageDigest md;
				
				md = MessageDigest.getInstance("SHA-256");
				md.update(new String(EnterPasswordField.getPassword()).getBytes());
		        String hashed = new String(md.digest());
		        
		        String savedHash = login.fetchUserDetails(textEnterUsername.getText());
		        
		        if(savedHash.equals("Error"))
		        	popup.showMessageDialog(null, "User does not exist. Please try again.",null,JOptionPane.ERROR_MESSAGE);
		        else if(savedHash.equals("Exception"))
		        	popup.showMessageDialog(null, "Error Occurred. Check details again.",null,JOptionPane.ERROR_MESSAGE);
		        else if(!savedHash.equals(hashed))
		        	popup.showMessageDialog(null, "Username Password Mismatch.",null,JOptionPane.ERROR_MESSAGE);
		        else
		        	card.show(fnl,"1");
				}
			catch(NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
//---------------------------------------------------------------------------------------------------
		// PANEL ONE...
		parent.add(one,"1");//adding JPanel one to JPanel parent(parent acts as a container)
		one.setLayout(null); //Used for Absolute Positioning
		one.setBackground(Color.WHITE);
		two.setBackground(Color.WHITE);
		three.setBackground(Color.WHITE);
		four.setBackground(Color.WHITE);
		five.setBackground(Color.WHITE);
		six.setBackground(Color.WHITE);
		seven.setBackground(Color.WHITE);
		eight.setBackground(Color.WHITE);
		nine.setBackground(Color.WHITE);
		ten.setBackground(Color.WHITE);
		zero.setBackground(Color.WHITE);
		
		
		//code for setting the title for the page
		JLabel title = new JLabel("Dallas Public Library");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Verdana", Font.BOLD, 17));
		title.setBounds(181, 25, 255, 30); // set the location of label on the panel
		one.add(title); // Add the Label to the panel(in this case, panel one)
	
		//add a button for navigation (search)
		JButton searchButton = new JButton("Search for a book");
		//used so that we can call the parent JPanel inside the ActionPerformed method
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				card.show(fnl,"2");
			}
		});
		
//-------------------------------------------------------------------------------------------------------
		
		//Panel TEN
		
	parent.add(ten,"10");
	ten.setLayout(null);
	
	
	JLabel lblBooksDue = new JLabel("Books due this week!");
	lblBooksDue.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBooksDue.setBounds(152, 11, 136, 31);
	ten.add(lblBooksDue);
	
	JButton btnBack_2 = new JButton("Back");
	btnBack_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		card.show(fnl,"1");
		
		}
	});
	btnBack_2.setBounds(284, 400, 89, 23);
	ten.add(btnBack_2);
	ten.add(scrollPane);
	scrollPane.setBounds(20,50,500,200);
	scrollPane.add(booksDueWeek);
	
	JButton btnShow = new JButton("Show");
	btnShow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		rs=due.dueDateThisWeek();
		try {
			if(rs.next())
			{
				
				booksDueWeek.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(booksDueWeek);
				scrollPane.setVisible(true);
				booksDueWeek.validate();
			}
			else
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	});
	btnShow.setBounds(27, 400, 89, 23);
	ten.add(btnShow);
	
		
//-------------------------------------------------------------------------------------------------------		
		// PANEL TWO
		searchButton.setToolTipText ("");
		searchButton.setBounds(35, 138, 191, 23);
		one.add(searchButton);//Add a button to the panel(in this case, panel one)
		
		parent.add(six,"6");
		six.setLayout(null);
		
		JLabel lblCheckingIn = new JLabel("Checking In");
		lblCheckingIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCheckingIn.setBounds(160, 11, 116, 20);
		six.add(lblCheckingIn);
		
		JCheckBox chkBookIdTo = new JCheckBox("Book ID:");
		chkBookIdTo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1)
					bookIDCheckInText.setVisible(true);
				else if(arg0.getStateChange()==2)
					{bookIDCheckInText.setVisible(false);
					bookIDCheckInText.setText("");
					}
			}
		});
		chkBookIdTo.setBounds(23, 56, 116, 14);
		six.add(chkBookIdTo);
		
		bookIDCheckInText = new JTextField();
		bookIDCheckInText.setBounds(210, 56, 183, 14);
		six.add(bookIDCheckInText);
		bookIDCheckInText.setColumns(10);
		bookIDCheckInText.setVisible(false);
		
		
		JCheckBox chkCardNoTo = new JCheckBox("Card No.:");
		chkCardNoTo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
					cardNoCheckInText.setVisible(true);
				else if(e.getStateChange()==2)
					{cardNoCheckInText.setVisible(false);
					cardNoCheckInText.setText("");
					}
			}
		});
		chkCardNoTo.setBounds(23, 101, 116, 14);
		six.add(chkCardNoTo);
		
		cardNoCheckInText = new JTextField();
		cardNoCheckInText.setBounds(210, 101, 183, 14);
		six.add(cardNoCheckInText);
		cardNoCheckInText.setColumns(10);
		cardNoCheckInText.setVisible(false);
		
		JCheckBox chkFirstNameCheckIn = new JCheckBox("First Name:");
		chkFirstNameCheckIn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
					firstNameCheckInText.setVisible(true);
				else if(e.getStateChange()==2)
					{firstNameCheckInText.setVisible(false);
					firstNameCheckInText.setText("");
					}
			}
		});
		chkFirstNameCheckIn.setBounds(23, 146, 116, 14);
		six.add(chkFirstNameCheckIn);
		
		firstNameCheckInText = new JTextField();
		firstNameCheckInText.setBounds(210, 146, 183, 14);
		six.add(firstNameCheckInText);
		firstNameCheckInText.setColumns(10);
		firstNameCheckInText.setVisible(false);
		
		JCheckBox chkLastName = new JCheckBox("Last Name:");
		chkLastName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
					lastNameCheckInText.setVisible(true);
				else if(e.getStateChange()==2)
					{lastNameCheckInText.setVisible(false);
					lastNameCheckInText.setText("");
					}
			}
		});
		chkLastName.setBounds(23, 191, 116, 14);
		six.add(chkLastName);
		
		lastNameCheckInText = new JTextField();
		lastNameCheckInText.setBounds(210, 191, 183, 14);
		six.add(lastNameCheckInText);
		lastNameCheckInText.setColumns(10);
		
		parent.add(seven,"7");
        seven.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Check In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(checkingBookTable.getSelectedRow()==-1)
					popup.showMessageDialog(null, "Please select an entry.",null,JOptionPane.WARNING_MESSAGE);
				else{
					try{
						rs.absolute(checkingBookTable.getSelectedRow()+1);
					
					loan_id = rs.getString("loan_id");
					}
					catch(Exception ex){}
			int n=checkIn.setLoanedBookInfo(loan_id);
			if(n==1)
				{
				popup.showMessageDialog(null, "Check In Successful for loan id: "+loan_id);
				card.show(fnl, "1");
				//	System.exit(0);
				}
				
			else
				popup.showMessageDialog(null, "error encountered. Restart application and try again.",null,JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		seven.add(btnNewButton);
		btnNewButton.setBounds(10, 10, 100, 50);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			card.show(fnl, "1");
			}
		});
		btnBack_1.setBounds(21, 428, 89, 23);
		seven.add(btnBack_1);
				
		JButton btnFindInfo = new JButton("Find Info");
		btnFindInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rs = checkIn.getLoanedBookInfo(bookIDCheckInText.getText(),cardNoCheckInText.getText(),firstNameCheckInText.getText(),lastNameCheckInText.getText());
				try {
					checkingBookTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				scroller.setViewportView(checkingBookTable);
				seven.add(scroller);
				scroller.setBounds(10,100,500,200);
			card.show(fnl, "7");
			
			}
		});
		btnFindInfo.setBounds(23, 228, 89, 23);
		six.add(btnFindInfo);
		
		JButton btnBackCheckingIn = new JButton("Back");
		btnBackCheckingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(fnl, "1");
			}
		});
		btnBackCheckingIn.setBounds(304, 228, 89, 23);
		six.add(btnBackCheckingIn);
		lastNameCheckInText.setVisible(false);
		
		JButton returnButton = new JButton("Return a book");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				card.show(fnl,"6");
			}
		});
		returnButton.setToolTipText("Click here to return a book.");
		returnButton.setBounds(290, 138, 191, 23);
		one.add(returnButton);
		
		JButton btnAddBorrower_1 = new JButton("Add New Borrower");
		btnAddBorrower_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			card.show(fnl, "5");
			}
		});
		btnAddBorrower_1.setBounds(35, 185, 191, 23);
		one.add(btnAddBorrower_1);
		
		parent.add(eight,"8");
        //eight.setLayout(new BorderLayout(0, 0));
        eight.setLayout(null);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		lblNewLabelFines.setVisible(false);
        		int outcome = fine.refreshFines();
        		// way to show the table again
        		if(outcome==1){
        		rs = fine.showFines();
    			table.setModel(DbUtils.resultSetToTableModel(rs));
        		}
        		else
        		{
        			popup.showMessageDialog(null, "Refresh failed!",null,JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnRefresh.setBounds(36, 228, 89, 23);
        eight.add(btnRefresh);
        
        JButton btnPayFine = new JButton("Pay Fine");
        btnPayFine.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabelFines.setVisible(false);
        		//System.out.println(table.getSelectedRow()+""+table.getSelectedColumn());//rao
        	if(!txtEnterCardNo.getText().isEmpty())
        	{
        		int outcome=fine.updateFines(txtEnterCardNo.getText());
        		if(outcome==1)
        			{
        			 rs = fine.showFines();
    			     table.setModel(DbUtils.resultSetToTableModel(rs));
        			}
        		else
        		{
        			popup.showMessageDialog(null, "Problem occured while updating record!",null,JOptionPane.ERROR_MESSAGE);
        		}
        	}
        	else
        		popup.showMessageDialog(null, "Enter Card Number first.",null,JOptionPane.WARNING_MESSAGE);
        	}
        });
        btnPayFine.setBounds(175, 385, 89, 23);
        eight.add(btnPayFine);
        
        
        txtEnterCardNo = new JTextField();
        txtEnterCardNo.setBounds(141, 298, 145, 20);
        eight.add(txtEnterCardNo);
        txtEnterCardNo.setColumns(10);
        
        JLabel lblEnterCardNo = new JLabel("Enter Card No:");
        lblEnterCardNo.setBounds(36, 301, 89, 14);
        eight.add(lblEnterCardNo);
        
        JButton btnBackPayFinesPage = new JButton("Back");
        btnBackPayFinesPage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtEnterCardNo.setText("");
        		txtEnterLoanId.setText("");
        		card.show(fnl,"1");
        	}
        });
        btnBackPayFinesPage.setBounds(175, 228, 89, 23);
        eight.add(btnBackPayFinesPage);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		rs = fine.searchFines(txtEnterCardNo.getText(), txtEnterName.getText());
        		table.setModel(DbUtils.resultSetToTableModel(rs));
        		lblNewLabelFines.setVisible(true);
        	}
        });
        btnSearch.setBounds(36, 385, 89, 23);
        eight.add(btnSearch);
        
        JLabel lblEnterName = new JLabel("Enter Name:");
        lblEnterName.setBounds(36, 342, 89, 14);
        eight.add(lblEnterName);
        
        txtEnterName = new JTextField();
        txtEnterName.setBounds(141, 339, 142, 20);
        eight.add(txtEnterName);
        txtEnterName.setColumns(10);
        
        lblNewLabelFines = new JLabel("Fines displayed for books which have been returned");
        lblNewLabelFines.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabelFines.setBounds(10, 0, 386, 14);
        eight.add(lblNewLabelFines);
        
        txtEnterLoanId = new JTextField();
        txtEnterLoanId.setBounds(374, 339, 125, 20);
        eight.add(txtEnterLoanId);
        txtEnterLoanId.setColumns(10);
        
        JButton btnPayPartialFine = new JButton("Pay Partial Fine");
        btnPayPartialFine.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	if(txtEnterCardNo.getText().isEmpty() || txtEnterLoanId.getText().isEmpty())
        		popup.showMessageDialog(null, "Enter Card Number AND Loan ID");
        	else
        	{
        	int n = fine.updatePartialFines(txtEnterCardNo.getText(), txtEnterLoanId.getText());
        	if(n==1)
        		popup.showMessageDialog(null, "Fine paid for loan ID: "+txtEnterLoanId.getText());
        	}
        	
        	}
        });
        btnPayPartialFine.setBounds(374, 385, 125, 23);
        eight.add(btnPayPartialFine);
        
        JLabel lblPayOnlyFor = new JLabel("Pay only for Loan ID :");
        lblPayOnlyFor.setBounds(374, 301, 125, 14);
        eight.add(lblPayOnlyFor);
        lblNewLabelFines.setVisible(false);
        table = new JTable();
        boolean pressingCTRL=false;//flag, if pressing CTRL it is true, otherwise it is false.
        Vector selectedCells = new Vector<int[]>();//int[]because every entry will store {cellX,cellY}
        
		JButton btnCheckFines = new JButton("Check Fines");
		btnCheckFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			card.show(fnl,"8");
			rs = fine.showFines();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			tablescroll.setViewportView(table);
			
			
			eight.add(tablescroll);
			tablescroll.setBounds(10, 13, 500, 180);
			}
		});
		btnCheckFines.setBounds(290, 185, 191, 23);
		one.add(btnCheckFines);
		
		JLabel lblThought = new JLabel("Thought for the day");
		lblThought.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblThought.setBounds(35, 282, 213, 23);
		one.add(lblThought);
		
		JTextArea txtrQuoteHere = new JTextArea();
		txtrQuoteHere.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		txtrQuoteHere.setText("Quote here");
		txtrQuoteHere.setBounds(35, 326, 300, 80);
		one.add(txtrQuoteHere);
		txtrQuoteHere.setLineWrap(true);
		txtrQuoteHere.setWrapStyleWord(true);
		txtrQuoteHere.setEditable(false);
		
		parent.add(nine,"9");
		nine.setLayout(null);
		
		JLabel lblAddingABook = new JLabel("Adding a book to database");
		lblAddingABook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddingABook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingABook.setBounds(101, 11, 192, 25);
		nine.add(lblAddingABook);
		
		JLabel lblBookId_1 = new JLabel("Book ID:");
		lblBookId_1.setBounds(45, 54, 46, 14);
		nine.add(lblBookId_1);
		
		textBookID = new JTextField();
		textBookID.setBounds(156, 51, 151, 14);
		nine.add(textBookID);
		textBookID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Title :");
		lblNewLabel.setBounds(45, 79, 86, 14);
		nine.add(lblNewLabel);
		
		textTitle = new JTextField();
		textTitle.setBounds(156, 79, 151, 14);
		nine.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setBounds(45, 104, 86, 14);
		nine.add(lblAuthorName);
		
		textAuthorName = new JTextField();
		textAuthorName.setBounds(156, 104, 151, 14);
		nine.add(textAuthorName);
		textAuthorName.setColumns(10);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(45, 129, 60, 14);
		nine.add(lblType);
		
		textType = new JTextField();
		textType.setBounds(156, 129, 151, 14);
		nine.add(textType);
		textType.setColumns(10);
		
		JLabel lblBranchId_1 = new JLabel("Branch ID :");
		lblBranchId_1.setBounds(45, 154, 70, 14);
		nine.add(lblBranchId_1);
		
		textBranchID = new JTextField();
		textBranchID.setBounds(156, 154, 151, 14);
		nine.add(textBranchID);
		textBranchID.setColumns(10);
		
		JLabel lblNoOfCopies = new JLabel("No. of copies :");
		lblNoOfCopies.setBounds(45, 179, 86, 14);
		nine.add(lblNoOfCopies);
		
		textCopies = new JTextField();
		textCopies.setBounds(156, 179, 151, 14);
		nine.add(textCopies);
		textCopies.setColumns(10);
		
		
		JButton btnAddBookTo = new JButton("Add book to database");
		btnAddBookTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			bookIDToAdd=textBookID.getText();
			authorNameToAdd=textAuthorName.getText();
			typeToAdd=textType.getText();
			titleToAdd=textTitle.getText();
			branchIDToAdd=textBranchID.getText();
			copiesToAdd=textCopies.getText();
			int num;
			num=book.insertBookRow(bookIDToAdd,titleToAdd,authorNameToAdd,typeToAdd,branchIDToAdd,copiesToAdd);
			if(num==0)
			{
				popup.showMessageDialog(null, "Book ID already exists.No of copies incremented!");
			}
			else if(num==-1)
			{
				popup.showMessageDialog(null, "Error Occurred! Check your input again.",null,JOptionPane.ERROR_MESSAGE);
			}
			else if(num==2)
			{
				popup.showMessageDialog(null, "Book added to a new branch with number of copies.");
			}
			else
			{
				popup.showMessageDialog(null, "Book added to database!");	
			}
			
			}
		});
		btnAddBookTo.setBounds(31, 231, 192, 23);
		nine.add(btnAddBookTo);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			card.show(fnl,"1");
			}
		});
		btnBack_3.setBounds(261, 231, 89, 23);
		nine.add(btnBack_3);
		JButton btnAddABook = new JButton("Add a book");
		btnAddABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(fnl,"9");
				
				
			}
		});
		btnAddABook.setBounds(35, 232, 191, 23);
		one.add(btnAddABook);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnLogOut.setBounds(305, 417, 89, 23);
		one.add(btnLogOut);
		
		JButton btnDeleteBook = new JButton("Books due this week");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			card.show(fnl, "10");
			}
		});
		btnDeleteBook.setBounds(290, 232, 191, 23);
		one.add(btnDeleteBook);
		rs = d.showQuote();
		try {
			if(rs.next())
				{String quote = rs.getString(2)+"\n"+rs.getString(3);
				txtrQuoteHere.setText(quote);
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			String defaultQuote = "Time is money	-	Anonymous";
			txtrQuoteHere.setText(defaultQuote);
		}	
		
		parent.add(two,"2");//adding JPanel two to JPanel parent(parent acts as a container)
		two.setLayout(null); //Used for Absolute Positioning
		
		JLabel searchTitle = new JLabel("Search For A Book To CheckOut");
		searchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		searchTitle.setFont(new Font("Verdana", Font.PLAIN, 15));
		searchTitle.setBounds(80, 27, 300, 30); // set the location of label on the panel
		two.add(searchTitle); // Add the Label to the panel(in this case, panel two)
		
		
		
		JLabel label = new JLabel("Choose to search :");
		label.setBounds(38, 91, 175, 14);
		two.add(label);
		
		JCheckBox idCheckbox = new JCheckBox("Book ID");
		idCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1)
					bookIdText.setVisible(true);
				else if(arg0.getStateChange()==2)
					{bookIdText.setVisible(false);
					bookIdText.setText("");
					}
			}
		});
		idCheckbox.setBounds(38, 117, 100, 23);
		two.add(idCheckbox);
		
		JCheckBox titleCheckbox = new JCheckBox("Book Title");
		titleCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==1)
					bookTitleText.setVisible(true);
				else if(arg0.getStateChange()==2)
					{bookTitleText.setVisible(false);
					bookTitleText.setText("");
					}
			}
		});
		titleCheckbox.setBounds(38, 143, 100, 23);
		two.add(titleCheckbox);
		
		JCheckBox authorCheckbox = new JCheckBox("Author");
		authorCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
					authorText.setVisible(true);
				else if(e.getStateChange()==2)
					{authorText.setVisible(false);
					authorText.setText("");
					}
			}
		});
		authorCheckbox.setBounds(38, 169, 100, 23);
		two.add(authorCheckbox);
		
//-------------------------------------------------------------------------------------------------------------------------
		// STARTING THE THIRD PANEL... which is the SEARCH RESULT PANEL
		parent.add(three,"3");
		
		JButton bookSearchButton = new JButton("Search your book ");
		bookSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(fnl,"3");
				rs=controller.searchResult(bookIdText.getText(),bookTitleText.getText(),authorText.getText());
				searchBookTable.setModel(DbUtils.resultSetToTableModel(rs));
				scroll.setViewportView(searchBookTable);
				scroll.validate();
				three.add(scroll);
				scroll.setBounds(10, 40,500, 200);
			}	
		});
		
		bookSearchButton.setBounds(38, 195, 150, 23);
		two.add(bookSearchButton);
		
		bookIdText = new JTextField();
		bookIdText.setText("");
		bookIdText.setBounds(186, 118, 175, 20);
		two.add(bookIdText);
		bookIdText.setColumns(10);
		bookIdText.setVisible(false);
		
		bookTitleText = new JTextField();
		bookTitleText.setText("");
		bookTitleText.setBounds(186, 144, 175, 20);
		two.add(bookTitleText);
		bookTitleText.setColumns(10);
		bookTitleText.setVisible(false);
		
		authorText = new JTextField();
		authorText.setText("");
		authorText.setBounds(186, 170, 175, 20);
		two.add(authorText);
		authorText.setColumns(10);
		
		JButton btnBackSearchPage = new JButton("Back");
		btnBackSearchPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(fnl, "1");
			}
		});
		btnBackSearchPage.setBounds(258, 195, 89, 23);
		two.add(btnBackSearchPage);
		authorText.setVisible(false);
		//three.setLayout(new BorderLayout(0, 0));
		three.setLayout(null);
		
		JButton btnCheckOut = new JButton("Check out");
		btnCheckOut.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				if(searchBookTable.getSelectedRow()==-1)
				{
					popup.showMessageDialog(null, "Select an item from the list.",null,JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					//fetch using table
					searchBookRowNum = searchBookTable.getSelectedRow() + 1;
					
	//				System.out.println(searchBookRowNum);//gives the index of the row selected(index starts from 0)
					try {
						rs.absolute(searchBookRowNum);
						bookIDToBorrow = rs.getString(1);//column index starts with 1
						bookTitleToBorrow = rs.getString(2);
						bookAuthorToBorrow = rs.getString(3);
						branchIDToBorrowFrom = rs.getString(4);
						noOfCopies = rs.getString(5);
						availableCopies = rs.getString(6);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					bookIDToBorrowText.setText(bookIDToBorrow);
					titleToBorrowText.setText(bookTitleToBorrow);
					authorToBorrowText.setText(bookAuthorToBorrow);
					branchIDToBorrowText.setText(branchIDToBorrowFrom);
					noOfCopiesToBorrowText.setText(noOfCopies);
					remCopiesToBorrowText.setText(availableCopies);
					
					card.show(fnl, "4");
					
				}
					
			}
		});
		three.add(btnCheckOut);
		//scroll.setVisible(true);
		btnCheckOut.setBounds(10, 0, 100, 20);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookIdText.setText("");
				bookTitleText.setText("");
				authorText.setText("");
				card.show(fnl, "1");
			}
		});
		btnBack.setBounds(52, 415, 89, 23);
		three.add(btnBack);
//------------------------------------------------------------------------------------------------------		
		//PANEL FOUR
		
		
		parent.add(four,"4");
		four.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setBounds(10, 11, 71, 14);
		four.add(lblBookId);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(10, 36, 71, 14);
		four.add(lblBookTitle);
		
		JLabel lblAuthors = new JLabel("Author(s)");
		lblAuthors.setBounds(10, 61, 71, 14);
		four.add(lblAuthors);
		
		JLabel lblBranchId = new JLabel("Branch ID");
		lblBranchId.setBounds(10, 86, 71, 14);
		four.add(lblBranchId);
		
		JLabel lblInventoriedCopies = new JLabel("No Of Copies");
		lblInventoriedCopies.setBounds(10, 111, 98, 14);
		four.add(lblInventoriedCopies);
		
		JLabel lblRemainingCopiesAt = new JLabel("Remcopies");
		lblRemainingCopiesAt.setBounds(10, 136, 98, 14);
		four.add(lblRemainingCopiesAt);
		
		bookIDToBorrowText = new JTextField();
		bookIDToBorrowText.setFont(new Font("Verdana", Font.PLAIN, 10));
		bookIDToBorrowText.setEditable(false);
		bookIDToBorrowText.setBounds(133, 11, 256, 14);
		four.add(bookIDToBorrowText);
		bookIDToBorrowText.setColumns(10);
		
		titleToBorrowText = new JTextField();
		titleToBorrowText.setFont(new Font("Verdana", Font.PLAIN, 10));
		titleToBorrowText.setEditable(false);
		titleToBorrowText.setText("");
		titleToBorrowText.setBounds(133, 36, 256, 14);
		four.add(titleToBorrowText);
		titleToBorrowText.setColumns(10);
		
		authorToBorrowText = new JTextField();
		authorToBorrowText.setFont(new Font("Verdana", Font.PLAIN, 10));
		authorToBorrowText.setEditable(false);
		authorToBorrowText.setBounds(133, 61, 256, 14);
		four.add(authorToBorrowText);
		authorToBorrowText.setColumns(10);
		
		branchIDToBorrowText = new JTextField();
		branchIDToBorrowText.setEditable(false);
		branchIDToBorrowText.setBounds(133, 86, 256, 14);
		four.add(branchIDToBorrowText);
		branchIDToBorrowText.setColumns(10);
		
		noOfCopiesToBorrowText = new JTextField();
		noOfCopiesToBorrowText.setEditable(false);
		noOfCopiesToBorrowText.setBounds(133, 111, 256, 14);
		four.add(noOfCopiesToBorrowText);
		noOfCopiesToBorrowText.setColumns(10);
		
		remCopiesToBorrowText = new JTextField();
		remCopiesToBorrowText.setEditable(false);
		remCopiesToBorrowText.setBounds(133, 136, 256, 14);
		four.add(remCopiesToBorrowText);
		remCopiesToBorrowText.setColumns(10);
		
		JLabel lblCardNo = new JLabel("Enter card number");
		lblCardNo.setBounds(10, 161, 150, 14);
		four.add(lblCardNo);
		
		cardNumberText = new JTextField();
		cardNumberText.setBounds(133, 161, 256, 14);
		four.add(cardNumberText);
		cardNumberText.setColumns(10);
		
		JButton btnAddBorrower = new JButton("Add borrower");
		btnAddBorrower.setBounds(249, 210, 150, 23);
		four.add(btnAddBorrower);
		btnAddBorrower.setVisible(false);
		final JButton buttonRef = btnAddBorrower;
		
		JButton finishCheckout = new JButton("Finish Checkout");
		finishCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cardNumber = cardNumberText.getText();
			int temp = borrower.doesBorrowerExist(cardNumber);
				if(temp==0)
				{
					popup.showMessageDialog(null, "Card number does not exist. Please add a new borrower.",null,JOptionPane.ERROR_MESSAGE);
					buttonRef.setVisible(true);
				}
			else if(temp == -1)
			{
				popup.showMessageDialog(null, "Oops. Some error while processing. Please restart application.",null,JOptionPane.ERROR_MESSAGE);
				}
		   else//biggest else
			{
			if(Integer.parseInt(availableCopies)==0)
				popup.showMessageDialog(null, "No more copies available to check out.",null,JOptionPane.ERROR_MESSAGE);
			else
			{
				
				int count=0;
				rs = checkOut.lookUpBorrower(cardNumber);
				try {
					rs.next();
					count = rs.getInt("total_borrowed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(count>=3)
					popup.showMessageDialog(null, "This borrower has reached the Limit of 3 books.",null,JOptionPane.WARNING_MESSAGE);
				else
				{
					
					int p;
					p=checkOut.checkIfFines(cardNumber);
					if(p==0)// rows exist with fines hold
					{
						popup.showMessageDialog(null, "Fines not yet paid by this card number!",null,JOptionPane.ERROR_MESSAGE);
					}
					else{
					//write insert query
					//on success, give popup saying Success
					int i = checkOut.insertNewBookLoan(bookIDToBorrow,branchIDToBorrowFrom,cardNumber);
					if(i==1)
					{
						popup.showMessageDialog(null, "Check out accomplished!");
						card.show(fnl,"1");
						cardNumberText.setText("");
						cardNumberText.setEditable(true);
						
						//System.exit(0);
					}
					else
					{
						popup.showMessageDialog(null, "Checkout failed!",null,JOptionPane.ERROR_MESSAGE);
					}
					
				}//end of checking if fines else
			}
			}//end of new else
			}//biggest else if borrower already there in book_loans
			}
			
		});
		finishCheckout.setBounds(10, 210, 150, 23);
		four.add(finishCheckout);
		
		
		parent.add(five,"5");
		five.setLayout(null);
		
		JLabel lblEnterDetailsFor = new JLabel("Enter Details for New Borrower");
		lblEnterDetailsFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterDetailsFor.setBounds(114, 11, 215, 14);
		five.add(lblEnterDetailsFor);
		
		JLabel labelFirstName = new JLabel("First Name :");
		labelFirstName.setBounds(39, 58, 95, 14);
		five.add(labelFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(190, 58, 159, 14);
		five.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel labelLastName = new JLabel("Last Name :");
		labelLastName.setBounds(39, 97, 95, 14);
		five.add(labelLastName);
		
		textLastName = new JTextField();
		textLastName.setText("");
		textLastName.setBounds(190, 97, 159, 14);
		five.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel labelAddress = new JLabel("Address :");
		labelAddress.setBounds(39, 136, 95, 14);
		five.add(labelAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(190, 136, 159, 14);
		five.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel labelPhoneNumber = new JLabel("Phone number :");
		labelPhoneNumber.setBounds(39, 175, 95, 14);
		five.add(labelPhoneNumber);
		
		textPhoneNo = new JTextField();
		textPhoneNo.setBounds(190, 175, 159, 14);
		five.add(textPhoneNo);
		textPhoneNo.setColumns(10);
		final JButton finalButton = btnAddBorrower;
		
		JButton btnBackFinishCheckOutPage = new JButton("Back");
		btnBackFinishCheckOutPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(fnl, "3");
				
				//refresh the table
/*
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scroll.add(table);
				three.add(scroll);*/
			}
		});
		btnBackFinishCheckOutPage.setBounds(10, 239, 150, 23);
		four.add(btnBackFinishCheckOutPage);
		JButton btnAddNewBorrower = new JButton("Add borrower to Database");
		btnAddNewBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fName=textFirstName.getText();
				lName=textLastName.getText();
				address=textAddress.getText();
				phone=textPhoneNo.getText();
				if(phone.equals(""))
				{
					phone=null;
				}
			if(fName.equals("")||lName.equals("")||address.equals(""))
			{
				 popup.showMessageDialog(null, "Please enter values into First name,Last name and Address fileds.These fields are mandatory!",null,JOptionPane.WARNING_MESSAGE);
			}
			else if(borrower.isDuplicate(fName,lName,address))
			{
				popup.showMessageDialog(null, "Borrower already exists.",null,JOptionPane.ERROR_MESSAGE);
			}
			else{
		 newInsertedCardNumber=borrower.enterNewBorrower(fName,lName,address,phone);
		       if(newInsertedCardNumber==0)
		       {
		    	   popup.showMessageDialog(null, "Borrower already exists!",null,JOptionPane.ERROR_MESSAGE);
		       }
		       else
		       {
		    	   int a = borrower.fetchCardNumber();
		    	   popup.showMessageDialog(null, "New borrower successfully added! Card Number is "+a);
		    	   Object[] options = {"Select a book","Proceed checkout"};
		    
                   int n = JOptionPane.showOptionDialog(null,"What would you like to do?",null,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,options,options[0]); //default button title
		    	   if(n==0)
		    	   {
		    		   cardNumberText.setText(new Integer(newInsertedCardNumber).toString());
			    	   cardNumberText.setEditable(false);
			    	 
			    	  if(searchBookTable.getSelectedRow()!=-1)
			    	  {
			    		  popup.showMessageDialog(null, "Only ONE book can be checked out at a time. Finish current checkout.",null,JOptionPane.ERROR_MESSAGE);
			    	  card.show(fnl,"4");
			    	  finalButton.setVisible(false);
			    	  }
			    	  else
			    	  card.show(fnl,"2");
		    		   
		    	   }
		    	   else if(n==1){
		    		   cardNumberText.setText(new Integer(newInsertedCardNumber).toString());
			    	   cardNumberText.setEditable(false);
			    	   buttonRef.setVisible(false);
		    		   if(bookIDToBorrow==null)
		    		   {
		    			   popup.showMessageDialog(null, "You have not selected a book yet!Please select a book to borrow.",null,JOptionPane.ERROR_MESSAGE);
		    			   card.show(fnl,"2");
		    		   }
		    		   else
		    		   {
		    	            card.show(fnl, "4");
		    	           
		    		   }
		    	   }
		       }
			}
			}
		});
		btnAddNewBorrower.setBounds(39, 217, 215, 23);
		five.add(btnAddNewBorrower);
		
		JButton btnBackNewBorrower = new JButton("Back");
		btnBackNewBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(fnl, "1");
			}
		});
		btnBackNewBorrower.setBounds(302, 217, 89, 23);
		five.add(btnBackNewBorrower);
		btnAddBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			card.show(fnl,"5");
			}
		});
		
		
		
		card.show(parent,"0");
		}
}
