
import React, { useState } from 'react';

import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

import Box from "@mui/material/Box";
import Button from '@mui/material/Button'
import axios from "axios";

export default function DelData(props) {
  // console.log(props.data[0])

  const get_id= props.dd
  const isDisabledDeleteButton = (get_id.length !== 1);
  const [openDel, setDel] = useState(false);
  const handleCloseDel = () => {
    setDel(false)
  }
  const handleOpenDel = () => {
    setDel(true);
  }
  const sl_no = props.dd[0]
  console.log(sl_no)
  const handleDelfunction = () => {
    setDel(false)
         
     
        axios.post('http://localhost:8081/HighRadiusProjectFinal/DeleteData',sl_no)
      
        .then((response) => {
            console.log(response);
        })
        .catch((error) => {
            console.log(error);
        });
        
    }



  return (
    <>
      <div>
        <Button className='btn' id='delbtn' onClick={handleOpenDel} variant='outlined' disabled={isDisabledDeleteButton} style={{height:'44px'}}>DELETE</Button>
        <Dialog open={openDel} onClose={handleCloseDel}       >
          <DialogTitle className='dialog' style={{ color: 'white' }}>
            Delete Records ?
          </DialogTitle>
          <DialogContent className='dialog'>
            <DialogContentText >
              <Box style={{ color: 'white' }}>
                Are you sure you want to delete these records[s] ?
              </Box>
            </DialogContentText>
          </DialogContent>
          <DialogActions className='dialog'>
            <Button style={{ width: '50%' }} variant='outlined' onClick={handleDelfunction}>DELETE </Button>
            <Button onClick={handleCloseDel} variant='outlined' style={{ width: '50%' }}>CANCEL</Button>

          </DialogActions>
        </Dialog>


      </div>
    </>
  );
}