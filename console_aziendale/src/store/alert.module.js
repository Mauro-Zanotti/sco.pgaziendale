const state = {
    type: null,
    message: null
};
const HttpErrors ={
    'INVALID_ROLES':'Ruoli non esistono',
	'INVALID_USER_DATA':'	Dati utente non validi',
	'NO_COMPANY'	:'Azienda specificata non esiste',
	'INVALID_COMPANY_DATA':'	Dati azienda non validi',
	'NO_APP'	:'Applicazione specificata non esiste',
	'NO_CAMPAIGN':'	Campagna specificata non esiste',
	'INVALID_CAMPAIGN_DATA':'	Dati campagna non validi',
	'NO_START_DATE'	:'Data inizio non specificata',
	'INVALID_APP_DATA':'	Dati app non validi',
	'NO_USER'	:'Utente non esiste',
	'NO_CODE'	:'Codice utente non esiste',
	'CODE_IN_USE'	:'Codice utente gia in uso',
	'NO_LOCATION'	:'Sede specificata non esiste',
	'INVALID_CSV'	:'Formato CSV non valido',
	'INVALID_GROUPING_DATA':'	Parametro non valido',
	'EMPTY_ROLES'	:'Non ci sono ruoli dell\'utente',
	'NO_EMPLOYEE'	:'Dipendente specificato non esiste',
	'NO_SUBSCRIPTION'	:'Non esiste registrazione per il codice specificato',
	'INVALID_PASSWORD'	:'Formatto password non valido',
	'LOGIN_IN_USE'	:'Nome utente giá usato',
	'BAD_REQUEST_DATA'	:'Dati di richiesta invalidi (quando si usa POST con id specificato)',
	'INVALID_IMPORT_DATA':'	Dati per import non sono validi',
  'BAD_CREDENTIALS'	:'Credenziali non validi',
	'INSUFFICIENT_RIGHTS':'	Non ha permessi',
	'GENERIC_ERROR'	:'Errore nel server. Contattare il supporto tecnico',
	'USER_ANOTHER_COMPANY'	:'Utente specificato é giá sottoscritto per un\'altra azienda',
	'REPEATING_SUBSCRIPTION'	:'Utente specificato ha giá I dati in precedenza',
}

const actions = {
    success({ commit }, message) {
        commit('success', message);
    },
    error({ commit }, message) {
        commit('error', message);
    },
    clear({ commit }) {
        commit('clear');
    }
};

const mutations = {
    success(state, message) {
        state.type = 'alert-success';
        state.message = message;
    },
    error(state, message) {
        state.type = 'alert-danger';
        state.message = HttpErrors[message];
    },
    clear(state) {
        state.type = null;
        state.message = null;
    }
};

export const alert = {
    namespaced: true,
    state,
    actions,
    mutations
};