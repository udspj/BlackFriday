//
//  mainViewController.m
//  blackfriday
//
//  Created by admin on 12-7-10.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "mainViewController.h"
#import "a1ViewController.h"
#import "a2ViewController.h"

@implementation mainViewController

@synthesize label;

NSDateFormatter* dateFormat;
NSDate *date;
NSDateComponents *datecomp;
NSCalendar *calendar;

-(void)getnowtime{
    dateFormat = [[NSDateFormatter alloc] init];//实例化一个NSDateFormatter对象  
    
    [dateFormat setDateFormat:@"yyyy-MM-dd HH:mm:ss"];//设定时间格式,这里可以设置成自己需要的格式  
    
    date = [NSDate date];
    
    datecomp = [[NSDateComponents alloc] init];
    
    NSInteger integer = NSYearCalendarUnit | 
    NSMonthCalendarUnit |
    NSDayCalendarUnit |
    NSWeekdayCalendarUnit |
    NSHourCalendarUnit |
    NSMinuteCalendarUnit |
    NSSecondCalendarUnit;
    
    calendar = [[NSCalendar alloc] initWithCalendarIdentifier:NSGregorianCalendar];
    
    datecomp = [calendar components:integer fromDate:date];
    
    //label.text = [NSString stringWithFormat:@"%d",[datecomp week]];
    
    label.text = [dateFormat stringFromDate:[NSDate date]];;
}
-(IBAction)btnchecknowtime:(id)sender{
    
   //a1ViewController *a1vc = [[a1ViewController alloc] initWithNibName:@"a1ViewController" bundle:Nil];
//    
//    UINavigationController *navigationController = [[UINavigationController alloc] init];
//    [self.view addSubview:navigationController.view];   
    
    //[self.navigationController pushViewController:a1vc animated:YES];
    
//[self.storyboard instantiateViewControllerWithIdentifier:@"a1"]; 
    
    //[self presentModalViewController:a1vc animated:YES];
    
    if ([datecomp weekday]==6 && [datecomp day]==13) {
        a2ViewController *avc = [self.storyboard instantiateViewControllerWithIdentifier:@"a2"];
        [self.navigationController pushViewController:avc animated:YES];
    } else {
        a1ViewController *avc = [self.storyboard instantiateViewControllerWithIdentifier:@"a1"];
        [self.navigationController pushViewController:avc animated:YES];
    }
}


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    [self performSelector:@selector(getnowtime)];
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

