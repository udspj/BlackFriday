//
//  weiboViewController.h
//  blackfriday
//
//  Created by admin on 12-7-13.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "WBEngine.h"
#import "WBSendView.h"
#import "WBLogInAlertView.h"

@interface weiboViewController : UIViewController<WBEngineDelegate,WBRequestDelegate>{
    WBEngine *weiBoEngine;
    IBOutlet UIButton *sendbtn;
    IBOutlet UITextField *uitf;
}

@property (nonatomic, retain) WBEngine *weiBoEngine;
@property(nonatomic,retain) UIButton *sendbtn;

-(IBAction)openwb:(id)sender;
-(IBAction)sendwb:(id)sender;
-(IBAction)closetext:(id)sender;

@end
