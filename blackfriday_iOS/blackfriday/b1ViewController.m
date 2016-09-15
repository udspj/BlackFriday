//
//  b1ViewController.m
//  blackfriday
//
//  Created by admin on 12-7-12.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "b1ViewController.h"
#import "weiboViewController.h"
#import "AppDelegate.h"

@implementation b1ViewController

@synthesize textview;


 // Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    [textview setUserInteractionEnabled:YES];
    [textview setEditable:NO];
    
    tarray = [NSArray arrayWithObjects:@"1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班",@"2今天不宜上班2今天不宜上班2今天不宜上班2今天不宜上班2今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班",@"3今天不宜上班3今天不宜上班3今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班",@"4今天不宜上班4今天不宜上班4今天不宜上班4今天不宜上班4今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班",@"5今天不宜上班5今天不宜上班5今天不宜上班5今天不宜上班5今天不宜上班5今天不宜上班5今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班1今天不宜上班", nil];
    int rand = arc4random()%5;
    [textview setText:[tarray objectAtIndex:rand]];
}

-(IBAction)toweibo:(id)sender{
    UIGraphicsBeginImageContext(self.view.frame.size);
    CGContextRef  context = UIGraphicsGetCurrentContext();
    [self.view.layer  renderInContext:context];
    UIImage *theImage = UIGraphicsGetImageFromCurrentImageContext();
    UIGraphicsEndImageContext(); 
    
    weiboViewController *wb = [self.storyboard instantiateViewControllerWithIdentifier:@"wb"];
    AppDelegate *appDelegate = [[UIApplication sharedApplication] delegate];  
    appDelegate.imgname = theImage; 
    [self.navigationController pushViewController:wb animated:YES];
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
