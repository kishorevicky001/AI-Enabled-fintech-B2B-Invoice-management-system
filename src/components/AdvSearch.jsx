import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import React from 'react';
import DialogTitle from '@mui/material/DialogTitle';
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from '@mui/material/Button'




export default function AdvSearch() {
    const [openAdvSearch, setAdvSearch] = React.useState(false);
const handleAdvanceSearchOpen = () => {
  setAdvSearch(true);
}
const handleAdvanceSearchClose = () => { 
  setAdvSearch(false);
}

return (
<>
<Button onClick={handleAdvanceSearchOpen} style={{ width: '180px' }} variant="outlined">ADVANCE SEARCH </Button>
<div>

      <Dialog open={openAdvSearch} onClose={handleAdvanceSearchClose}>
        <DialogTitle>ADVANCE SEARCH</DialogTitle>
        <DialogContent >
          <Box
            component="form"
            sx={{
              "& .MuiTextField-root": { m: 1.6, width: "27ch" }
            }}
            noValidate
            autoComplete="off"
          >
            <TextField
              id="outlined-multiline-flexible"
              label="Document ID"
              multiline
              maxRows={4}
              variant="filled"

            />
            <TextField
              id="outlined-multiline-flexible"
              label="Invoice Id"
              multiline
              maxRows={4}
              variant="filled"

            />
            <TextField
              id="outlined-multiline-flexible"
              label="Customer Number"
              multiline
              maxRows={4}
              variant="filled"
            />
            <TextField
              id="outlined-multiline-flexible"
              label="Business Year"
              multiline
              maxRows={4}
              variant="filled"

            />





          </Box>



        </DialogContent>
        <DialogActions>
          <Button onClick={handleAdvanceSearchClose} style={{ width: '300px' }} variant='outlined'>Cancel</Button>
          <Button style={{ width: '300px' }} variant='outlined'>SEARCH</Button>
        </DialogActions>





      </Dialog>





</div>


</>);
}