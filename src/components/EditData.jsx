import React,{useState} from 'react';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from '@mui/material/Button'
import axios from 'axios';

export default function EditData(props) {
    const [openEdit, setEdit] = React.useState(false);
    const [invoice_currency, setInvoice_currency] = useState('');
    const [cust_payment_terms, setCust_payment_terms] = useState('');
    const [sl_no, setSl_no] = useState(0);
    const handleEditOpen = ()=>{
        setEdit(true);
    }
    const handleEditClose= () =>{
        setEdit(false)
    }
    console.log(props.Editdata[0]+" Edited");
    const edit1 = (event) => {
        setInvoice_currency(event.target.value);
        setSl_no(props.Editdata[0]);
    };
    const edit2 = (event) => {
        setCust_payment_terms(event.target.value);
    };
    const get_id= props.Editdata
    const isDisabledEditButton = (get_id.length !== 1);

    const handleEdit = () => {
        setEdit(false)
         
        if(
            sl_no !== '' &&
            invoice_currency !== '' &&
            cust_payment_terms !== '' 
    
        ) {
            axios.get(
                'http://localhost:8081/HighRadiusProjectFinal/EditData?', 
                {params:{
                    sl_no, 
                    invoice_currency,
                    cust_payment_terms
                }
                   
                }
            )
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            });
           
            
        }
        setInvoice_currency("");
        setCust_payment_terms("");
    }


   
    return (
         <>
          <Button className='btn' id='editbtn' onClick={handleEditOpen} disabled={isDisabledEditButton} variant="outlined" >EDIT</Button>
            
            <div>
                <Dialog open={openEdit} onClose={handleEditClose}>
                    <DialogTitle className='dialog'>EDIT</DialogTitle>
                    <DialogContent className='dialog' >
                        <Box
                            component="form"
                            sx={{
                                "& .MuiTextField-root": { m: 1.6, width: "27ch" }
                            }}
                            noValidate
                            autoComplete="off"
                        >
                            <TextField
                                className="outlined-multiline-flexible"
                                label="Invoice Currency"
                                multiline
                                variant="filled"
                                name='Invoice_currency'
                                value={invoice_currency}
                                //value={{Invoice_currency}}
                                maxRows={4}
                                onChange={(e) =>edit1(e)}


                            />
                            <TextField
                                className="outlined-multiline-flexible"
                                label="Customer Payment Terms"
                                multiline
                               
                                name='cust_payment_terms'
                                variant="filled"
                                value={cust_payment_terms}
                                //value={{Cust_payment_terms}}
                                maxRows={4}
                                onChange={(e) =>edit2(e)}

                            />

                        </Box>

                    </DialogContent>
                    <DialogActions className='dialog'>
                        <Button style={{ width: '50%' }} variant='outlined' onClick={handleEdit}>EDIT</Button>
                        <Button style={{ width: '50%' }} variant='outlined'  onClick={handleEditClose}>Cancel</Button>
                    </DialogActions>

                </Dialog>
            </div>
        </>)
}