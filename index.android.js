'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Button,
  DeviceEventEmitter,
} from 'react-native';

import NativeToastAndroid from './src/component/NativeToastAndroid';
import TimeModule from './src/component/TimeModule';
import IntentModule from './src/component/IntentModule';

class HelloWorld extends React.Component {

    constructor(props){
        super(props);

        this.state={name:'',sex:''};
    }

componentWillMount(){
    DeviceEventEmitter.addListener("sendTime",(msg)=>{

    let value = "";
    if(typeof msg =='object'){
     let {key:value} =msg;
     NativeToastAndroid.show(value,NativeToastAndroid.SHORT);
    } else {
         NativeToastAndroid.show(msg,NativeToastAndroid.SHORT);

    }

    });
}

componentDidMount(){
    IntentModule.getDataFromIntent((obj)=>{
    let {name,sex} = obj;
    console.log("---" + name+"---" + sex);
    },(error)=>{
        alert(error);
    })

}

  toastFromeNative = ()=>{
    NativeToastAndroid.show("I'm toast",NativeToastAndroid.SHORT);
  }

  getTime = ()=>{
    TimeModule.getTime();
  }

  finish = ()=>{
    IntentModule.finish("finish this react");
  }
  render() {
    return (
      <View style={styles.container}>
        <Text onPres={this.toastFromeNative} style={styles.hello}>Hello, World shhs</Text>
        <Button title="toast" onPress={this.toastFromeNative}/>
        <Button title="getTime" onPress={this.getTime}/>
        <Text>{this.state.name}00000</Text>
        <Button title="finish" onPress={this.finish}/>
      </View>
    )
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor:'blue',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);