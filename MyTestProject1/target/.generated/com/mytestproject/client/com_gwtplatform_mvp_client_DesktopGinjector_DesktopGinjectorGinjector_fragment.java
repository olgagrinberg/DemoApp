package com.mytestproject.client;

import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.com_gwtplatform_mvp_client_DesktopGinjector_DesktopGinjectorGinjector;

public class com_gwtplatform_mvp_client_DesktopGinjector_DesktopGinjectorGinjector_fragment {
  public void memberInject_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$(com.mytestproject.client.ApplicationPresenter.MyProxy injectee) {
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$(com.mytestproject.client.ApplicationPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$(com.mytestproject.client.HomePagePresenter.MyProxy injectee) {
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$(com.mytestproject.client.HomePagePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$HomePageView$Binder$_annotation$$none$$(com.mytestproject.client.HomePageView.Binder injectee) {
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$(com.mytestproject.client.HomePageView injectee) {
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$ApplicationView$Binder$_annotation$$none$$(com.mytestproject.client.ApplicationView.Binder injectee) {
    
  }
  
  public void memberInject_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$(com.mytestproject.client.ApplicationView injectee) {
    
  }
  
  
  /**
   * Binding for com.mytestproject.client.HomePagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:122)
   */
  public com.mytestproject.client.HomePagePresenter.MyView get_Key$type$com$mytestproject$client$HomePagePresenter$MyView$_annotation$$none$$() {
    com.mytestproject.client.HomePagePresenter.MyView result = get_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for com.mytestproject.client.ApplicationPresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:122)
   */
  public com.mytestproject.client.ApplicationPresenter.MyView get_Key$type$com$mytestproject$client$ApplicationPresenter$MyView$_annotation$$none$$() {
    com.mytestproject.client.ApplicationPresenter.MyView result = get_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$();
    return result;
    
  }
  
  private com.mytestproject.client.ApplicationPresenter.MyProxy singleton_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$ = null;
  
  public com.mytestproject.client.ApplicationPresenter.MyProxy get_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(com.mytestproject.client.ApplicationPresenter.MyProxy.class);
    assert created instanceof com.mytestproject.client.ApplicationPresenter.MyProxy;
    com.mytestproject.client.ApplicationPresenter.MyProxy result = (com.mytestproject.client.ApplicationPresenter.MyProxy) created;
    
    memberInject_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$;
    
  }
  
  private com.mytestproject.client.ApplicationPresenter singleton_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$ = null;
  
  public com.mytestproject.client.ApplicationPresenter get_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$ == null) {
    com.mytestproject.client.ApplicationPresenter result = com$mytestproject$client$ApplicationPresenter_com$mytestproject$client$ApplicationPresenter_methodInjection(injector.getFragment_com_google_web_bindery_event_shared().get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$mytestproject$client$ApplicationPresenter$MyView$_annotation$$none$$(), get_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$());
    memberInject_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$;
    
  }
  
  public com.mytestproject.client.ApplicationPresenter com$mytestproject$client$ApplicationPresenter_com$mytestproject$client$ApplicationPresenter_methodInjection(com.google.web.bindery.event.shared.EventBus _0, com.mytestproject.client.ApplicationPresenter.MyView _1, com.mytestproject.client.ApplicationPresenter.MyProxy _2) {
    return new com.mytestproject.client.ApplicationPresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.mytestproject.client.ApplicationPresenter> declared at:
   *   Implicit provider for com.google.inject.Provider<com.mytestproject.client.ApplicationPresenter>
   */
  public com.google.inject.Provider<com.mytestproject.client.ApplicationPresenter> get_Key$type$com$google$inject$Provider$com$mytestproject$client$ApplicationPresenter$$_annotation$$none$$() {
    com.google.inject.Provider<com.mytestproject.client.ApplicationPresenter> result = new com.google.inject.Provider<com.mytestproject.client.ApplicationPresenter>() { 
      public com.mytestproject.client.ApplicationPresenter get() { 
        return get_Key$type$com$mytestproject$client$ApplicationPresenter$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  private com.mytestproject.client.HomePagePresenter.MyProxy singleton_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$ = null;
  
  public com.mytestproject.client.HomePagePresenter.MyProxy get_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(com.mytestproject.client.HomePagePresenter.MyProxy.class);
    assert created instanceof com.mytestproject.client.HomePagePresenter.MyProxy;
    com.mytestproject.client.HomePagePresenter.MyProxy result = (com.mytestproject.client.HomePagePresenter.MyProxy) created;
    
    memberInject_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$;
    
  }
  
  private com.mytestproject.client.HomePagePresenter singleton_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$ = null;
  
  public com.mytestproject.client.HomePagePresenter get_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$ == null) {
    com.mytestproject.client.HomePagePresenter result = com$mytestproject$client$HomePagePresenter_com$mytestproject$client$HomePagePresenter_methodInjection(injector.getFragment_com_google_web_bindery_event_shared().get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$mytestproject$client$HomePagePresenter$MyView$_annotation$$none$$(), get_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$());
    memberInject_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$;
    
  }
  
  public com.mytestproject.client.HomePagePresenter com$mytestproject$client$HomePagePresenter_com$mytestproject$client$HomePagePresenter_methodInjection(com.google.web.bindery.event.shared.EventBus _0, com.mytestproject.client.HomePagePresenter.MyView _1, com.mytestproject.client.HomePagePresenter.MyProxy _2) {
    return new com.mytestproject.client.HomePagePresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.mytestproject.client.HomePagePresenter> declared at:
   *   Implicit provider for com.google.inject.Provider<com.mytestproject.client.HomePagePresenter>
   */
  public com.google.inject.Provider<com.mytestproject.client.HomePagePresenter> get_Key$type$com$google$inject$Provider$com$mytestproject$client$HomePagePresenter$$_annotation$$none$$() {
    com.google.inject.Provider<com.mytestproject.client.HomePagePresenter> result = new com.google.inject.Provider<com.mytestproject.client.HomePagePresenter>() { 
      public com.mytestproject.client.HomePagePresenter get() { 
        return get_Key$type$com$mytestproject$client$HomePagePresenter$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  
  /**
   * Binding for com.mytestproject.client.HomePageView$Binder declared at:
   *   Implicit GWT.create binding for com.mytestproject.client.HomePageView$Binder
   */
  public com.mytestproject.client.HomePageView.Binder get_Key$type$com$mytestproject$client$HomePageView$Binder$_annotation$$none$$() {
    Object created = GWT.create(com.mytestproject.client.HomePageView.Binder.class);
    assert created instanceof com.mytestproject.client.HomePageView.Binder;
    com.mytestproject.client.HomePageView.Binder result = (com.mytestproject.client.HomePageView.Binder) created;
    
    memberInject_Key$type$com$mytestproject$client$HomePageView$Binder$_annotation$$none$$(result);
    
    return result;
    
  }
  
  private com.mytestproject.client.HomePageView singleton_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$ = null;
  
  public com.mytestproject.client.HomePageView get_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$ == null) {
    com.mytestproject.client.HomePageView result = com$mytestproject$client$HomePageView_com$mytestproject$client$HomePageView_methodInjection(get_Key$type$com$mytestproject$client$HomePageView$Binder$_annotation$$none$$());
    memberInject_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$HomePageView$_annotation$$none$$;
    
  }
  
  public com.mytestproject.client.HomePageView com$mytestproject$client$HomePageView_com$mytestproject$client$HomePageView_methodInjection(com.mytestproject.client.HomePageView.Binder _0) {
    return new com.mytestproject.client.HomePageView(_0);
  }
  
  
  /**
   * Binding for com.mytestproject.client.ApplicationView$Binder declared at:
   *   Implicit GWT.create binding for com.mytestproject.client.ApplicationView$Binder
   */
  public com.mytestproject.client.ApplicationView.Binder get_Key$type$com$mytestproject$client$ApplicationView$Binder$_annotation$$none$$() {
    Object created = GWT.create(com.mytestproject.client.ApplicationView.Binder.class);
    assert created instanceof com.mytestproject.client.ApplicationView.Binder;
    com.mytestproject.client.ApplicationView.Binder result = (com.mytestproject.client.ApplicationView.Binder) created;
    
    memberInject_Key$type$com$mytestproject$client$ApplicationView$Binder$_annotation$$none$$(result);
    
    return result;
    
  }
  
  private com.mytestproject.client.ApplicationView singleton_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$ = null;
  
  public com.mytestproject.client.ApplicationView get_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$() {
    
    if (singleton_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$ == null) {
    com.mytestproject.client.ApplicationView result = com$mytestproject$client$ApplicationView_com$mytestproject$client$ApplicationView_methodInjection(get_Key$type$com$mytestproject$client$ApplicationView$Binder$_annotation$$none$$());
    memberInject_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$(result);
    
        singleton_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$mytestproject$client$ApplicationView$_annotation$$none$$;
    
  }
  
  public com.mytestproject.client.ApplicationView com$mytestproject$client$ApplicationView_com$mytestproject$client$ApplicationView_methodInjection(com.mytestproject.client.ApplicationView.Binder _0) {
    return new com.mytestproject.client.ApplicationView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_gwtplatform_mvp_client_DesktopGinjector_DesktopGinjectorGinjector injector;
  public com_gwtplatform_mvp_client_DesktopGinjector_DesktopGinjectorGinjector_fragment(com_gwtplatform_mvp_client_DesktopGinjector_DesktopGinjectorGinjector injector) {
    this.injector = injector;
  }
  
  public void initializeEagerSingletons() {
    // Eager singleton bound at:
    //   Implicit GWT.create binding for com.mytestproject.client.ApplicationPresenter$MyProxy
    get_Key$type$com$mytestproject$client$ApplicationPresenter$MyProxy$_annotation$$none$$();
    // Eager singleton bound at:
    //   Implicit GWT.create binding for com.mytestproject.client.HomePagePresenter$MyProxy
    get_Key$type$com$mytestproject$client$HomePagePresenter$MyProxy$_annotation$$none$$();
    
  }
  
}
