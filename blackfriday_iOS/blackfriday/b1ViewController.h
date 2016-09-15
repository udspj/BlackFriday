//
//  b1ViewController.h
//  blackfriday
//
//  Created by admin on 12-7-12.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface b1ViewController : UIViewController{
    IBOutlet UITextView *textview;
    NSArray *tarray;
}

@property(nonatomic,retain)UITextView *textview;

-(IBAction)toweibo:(id)sender;

@end
