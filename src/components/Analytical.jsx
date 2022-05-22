import Button from '@mui/material/Button'
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import React from 'react';
import DialogTitle from '@mui/material/DialogTitle';
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
export default function Analytical() {
    const [openAnalytics, setAnalytics] = React.useState(false);
    const handleAnalyticsOpen = () => {
      setAnalytics(true);
    }
    const handleAnalyticsClose = () => { 
      setAnalytics(false);
    }
    return(
        <>
        <Button variant="outlined" style={{width:'170px'}} onClick={handleAnalyticsOpen}>ANALYTICS</Button>


        <div>

      <Dialog open={openAnalytics} onClose={handleAnalyticsClose}>
        <DialogTitle>Analytics View</DialogTitle>
        <DialogContent >
          <Box
            component="form"
            sx={{
              "& .MuiTextField-root": { m: 1.6, width: "29ch" }
            }}
            noValidate
            autoComplete="off"
          >
              <label>
            Clear date:<br/>
            <TextField
              id="date"
              label="From"
              type="date"
             
              sx={{ width: 280 }}
              variant="filled"
              

            />
            <TextField
              id="date"
              label="To"
              type="date"
             
              sx={{ width: 280 }}
              variant="filled"
              
            />
            </label>


            <label>
            Due date:<br/>
            <TextField
              id="date"
              label="From"
              type="date"
             
              sx={{ width: 280 }}
              variant="filled"
              

            />
            <TextField
              id="date"
              label="To"
              type="date"
             
              sx={{ width: 280 }}
              variant="filled"
              

            />
            </label>
            <label>
             Base Line Create Date:<br/>
            <TextField
              id="date"
              label="From"
              type="date"
             
              sx={{ width: 280 }}
              variant="filled"
              
            />
            <TextField
             id="date"
             label="To"
             type="date"
            
             sx={{ width: 280 }}
             variant="filled"
             
            />
            </label>

            <label>
             Invoice currency:<br/>
            <TextField
              id="outlined-multiline-flexible"
              label="Invoice Currency"
              multiline
              maxRows={4}
              variant="filled"

            />
            </label>
            





          </Box>



        </DialogContent>
        <DialogActions>
          <Button onClick={handleAnalyticsClose} style={{ width: '300px' }} variant='outlined'>CANCEL</Button>
          <Button style={{ width: '300px' }} variant='outlined' onClick={handleAnalyticsClose}>SUBMIT</Button>
        </DialogActions>





      </Dialog>





</div>


        
        
        
        </>



    );


}