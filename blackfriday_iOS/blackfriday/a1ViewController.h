//
//  aViewController.h
//  blackfriday
//
//  Created by admin on 12-7-11.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface a1ViewController : UIViewController{
    IBOutlet UILabel *datelabel;
    IBOutlet UILabel *countdownlabel;
    NSInteger integer;
    NSDate *date;
    NSDateComponents *datecomp;
    NSCalendar *calendar;
    bool isbreak;
    NSDateComponents *middatecomp;
    int m;
    int n;
    NSDate *dd;
    NSTimer *tt;
    NSDateComponents *mindc;
}

@property(nonatomic,retain)UILabel *datelabel;
@property(nonatomic,retain)UILabel *countdownlabel;

-(IBAction)godivine:(id)sender;

@end
