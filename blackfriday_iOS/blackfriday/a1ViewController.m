//
//  aViewController.m
//  blackfriday
//
//  Created by admin on 12-7-11.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "a1ViewController.h"
#import "b1ViewController.h"

@implementation a1ViewController

@synthesize datelabel;
@synthesize countdownlabel;

-(IBAction)godivine:(id)sender{
    b1ViewController *bvc = [self.storyboard instantiateViewControllerWithIdentifier:@"b1"];
    [self.navigationController pushViewController:bvc animated:YES];
}

-(void)shownextfriday{
    date = [NSDate date];
    
    NSDateFormatter *dateformat = [[NSDateFormatter alloc]init];
    [dateformat setDateFormat:@"yyyy MM/dd HH:mm:ss"];
    
    integer = NSYearCalendarUnit | 
    NSMonthCalendarUnit |
    NSDayCalendarUnit |
    NSWeekdayCalendarUnit |
    NSHourCalendarUnit |
    NSMinuteCalendarUnit |
    NSSecondCalendarUnit;
    datecomp = [[NSDateComponents alloc] init];
    calendar = [[NSCalendar alloc] initWithCalendarIdentifier:NSGregorianCalendar];
    datecomp = [calendar components:integer fromDate:date];
    
    middatecomp = [[NSDateComponents alloc] init];
    //middatecomp = [calendar components:integer fromDate:date];
    
    //countdownlabel.text = [NSString stringWithFormat:@"%d,%d,%d,%d",[datecomp year],[datecomp month],[datecomp day],[datecomp weekday]];
    
    for (m = [datecomp year]; m < [datecomp year]+2; m ++) {
        for (n = 0; n < 13; n ++) {
            [middatecomp setYear:m];
            [middatecomp setMonth:n];
            [middatecomp setDay:13];
            
            dd = [calendar dateFromComponents:middatecomp];
            NSDateComponents *ddc = [calendar components:integer fromDate:dd];
            
            if ([ddc weekday] == 6) {
                if (m == [datecomp year] && n > [datecomp month]) {
                    isbreak = true;
                    break;
                }else if(m > [datecomp year]){
                    isbreak = true;
                    break;
                }else if(m == [datecomp year] && n == [datecomp month] && [datecomp day] < 13){
                    isbreak = true;
                    break;
                }else{
                    continue;
                }
            }
        }
        if (isbreak == true) {
            break;
        }
    }
    datelabel.text = [NSString stringWithFormat:@"next black Friday : %d %d/13",[middatecomp year],[middatecomp month]];
    
    //datelabel.text = [dateformat stringFromDate:[NSDate date]];
    
}

-(void)daojishi{
    date = [NSDate date];
    NSInteger inte = NSDayCalendarUnit |
    NSHourCalendarUnit |
    NSMinuteCalendarUnit |
    NSSecondCalendarUnit;
    mindc = [calendar components:inte fromDate:date toDate:dd options:0];
    countdownlabel.text = [NSString stringWithFormat:@"%d Days %d:%d:%d",[mindc day],[mindc hour],[mindc minute],[mindc second]];
}


 // Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
 - (void)viewDidLoad
 {
 [super viewDidLoad];
     isbreak = false;
     [self performSelector:@selector(shownextfriday)];
     [self performSelector:@selector(daojishi)];//先初始化一下，timer会一秒后才显示
     tt = [NSTimer scheduledTimerWithTimeInterval:1 target:self selector:@selector(daojishi) userInfo:nil repeats:YES];
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
