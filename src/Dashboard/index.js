import React, { useState } from 'react'
import { View, TextInput, Alert, Button } from 'react-native'

import { NativeModules } from 'react-native';

const ToastModule = NativeModules.ToastModule;

const Dashboard = () => {
    const handleAdd = async () => {
        // ToastModule.openImageSwiper(['Pramit','Agravat'])
        ToastModule.showToast('This is a Image List Demo')
    };

    return (
        <View>
            <Button title="Add" onPress={() => handleAdd()} />
        </View>
    );
};

export default Dashboard