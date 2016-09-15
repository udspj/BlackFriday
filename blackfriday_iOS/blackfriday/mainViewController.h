//
//  mainViewController.h
//  blackfriday
//
//  Created by admin on 12-7-10.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
//#import "a1ViewController.h"

@interface mainViewController : UIViewController{
    IBOutlet UILabel *label;
    //a1ViewController *a1vc;
    //NSDate *date;
}

@property(retain,nonatomic)UILabel *label;

-(IBAction)btnchecknowtime:(id)sender;


@end
