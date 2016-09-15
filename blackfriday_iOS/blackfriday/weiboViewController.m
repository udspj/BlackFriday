//
//  weiboViewController.m
//  blackfriday
//
//  Created by admin on 12-7-13.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "weiboViewController.h"
#import "AppDelegate.h"

@implementation weiboViewController;

@synthesize weiBoEngine;
@synthesize sendbtn;

-(IBAction)openwb:(id)sender{
    [weiBoEngine logIn];
}
-(IBAction)sendwb:(id)sender{
    
    AppDelegate *appDelegate = [[UIApplication sharedApplication] delegate]; 
    [weiBoEngine sendWeiBoWithText:uitf.text image:appDelegate.imgname];
    
}
-(void)engine:(WBEngine *)engine requestDidSucceedWithResult:(id)result{
    UIAlertView* alertView = [[UIAlertView alloc]initWithTitle:nil 
													   message:@"微博发送成功！" 
													  delegate:nil
											 cancelButtonTitle:@"确定" 
											 otherButtonTitles:nil];
	[alertView show];
}

- (void)engineDidLogIn:(WBEngine *)engine
{
    UIAlertView* alertView = [[UIAlertView alloc]initWithTitle:nil 
													   message:@"登录成功！" 
													  delegate:self
											 cancelButtonTitle:@"确定" 
											 otherButtonTitles:nil];
    [alertView show];
    [sendbtn setHidden:NO];
}
- (void)engine:(WBEngine *)engine didFailToLogInWithError:(NSError *)error
{
    UIAlertView* alertView = [[UIAlertView alloc]initWithTitle:nil 
													   message:@"登录失败！" 
													  delegate:nil
											 cancelButtonTitle:@"确定" 
											 otherButtonTitles:nil];
	[alertView show];
}

-(IBAction)closetext:(id)sender{
    [uitf resignFirstResponder];
}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

/*
// Implement loadView to create a view hierarchy programmatically, without using a nib.
- (void)loadView
{
}
*/


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    [sendbtn setHidden:YES];
    
    WBEngine *engine = [[WBEngine alloc] initWithAppKey:@"1616155755" appSecret:@"50ec0b7966bbfd9f24dd3668560a2ff1"];
    [engine setRootViewController:self];
    [engine setDelegate:self];
    [engine setRedirectURI:@"http://"];
    [engine setIsUserExclusive:NO];
    self.weiBoEngine = engine;
}


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
