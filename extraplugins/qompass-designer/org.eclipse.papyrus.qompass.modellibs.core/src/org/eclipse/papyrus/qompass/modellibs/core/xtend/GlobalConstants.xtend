/*******************************************************************************
* Copyright (c) 2014 Zeligsoft (2009) Limited  and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.xtend

class GlobalConstants {
    public static val QUAL_NAME_SEP             = "."
    public static val FUNC_NAME_QUAL_NAME_SEP   = "__"
    public static val FUNC_NAME_PART_SEP        = "____"
    public static val INJECT_FUNC_NAME          = "inject"
    public static val INITIALIZE_FUNC_NAME      = "initialize"
    public static val STATE_FUNC_PREFIX         = "state_"
    public static val JUNCTION_FUNC_PREFIX      = "junction_"
    public static val CHOICE_FUNC_PREFIX        = "choice_"
    public static val ACTION_CHAIN_FUNC_PREFIX  = "actionchain_"
    public static val ACTION_FUNC_PREFIX        = "action_"
    public static val GUARD_FUNC_PREFIX         = "guard_"
    public static val USER_ACTION_FUNC_PREFIX   = "useraction_"
    public static val USER_GUARD_FUNC_PREFIX    = "userguard_"
    public static val EXIT_ACTION_FUNC_PREFIX   = "exitaction_"
    public static val ENTRY_ACTION_FUNC_PREFIX  = "entryaction_"
    public static val TRANS_ACTION_FUNC_PREFIX  = "transitionaction_"
    public static val SAVE_HISTORY_FUNC_NAME    = "save_history"
    public static val CHECK_HISTORY_FUNC_NAME   = "check_history"
    public static val CHECK_HISTORY_FUNC_PREFIX = "checkhistory_"
    public static val CURRENT_STATE_FIELD_NAME  = "currentState"
    public static val HISTORY_TABLE_NAME        = "history"
    public static val UNDEFINED                 = "SPECIAL_INTERNAL_STATE_UNDEFINED"
    public static val UNVISITED                 = "SPECIAL_INTERNAL_STATE_UNVISITED"
    public static val STATE_TYPE_NAME           = "State"
    public static val PORT_TYPE_NAME            = "Port"
    public static val SIGNAL_TYPE_NAME          = "Signal"
    public static val INJECT_FUNC_PARAM         = "msg"
    public static val INITIALIZE_FUNC_PARAM     = "msg"
    public static val STATE_FUNC_PARAM          = "msg"
    public static val JUNC_FUNC_PARAM           = "msg"
    public static val CHOICE_FUNC_PARAM         = "msg"
    public static val CHAIN_FUNC_PARAM          = "msg"
    public static val ACTION_FUNC_PARAM         = "msg"
    public static val ACTION_DATA_VARIABLE      = "rtdata"
    public static val EMPTY_ACTION_COMMENT      = "// (Automatically generated stub for an empty action)"
    public static val MISSING_CODE_COMMENT      = "// (No C++ code found for this action)"
    public static val MISSING_CONSTRAINT_BODY   = "false"
    public static val FRESH_NAME_PREFIX               = "new_"
    public static val FRESH_ENTRYPOINT_NAME_PREFIX    = "new_entrypoint_"
    public static val FRESH_EXITPOINT_NAME_PREFIX     = "new_exitpoint_"
    public static val FRESH_CHOICEPOINT_NAME_PREFIX   = "new_choice_"
    public static val FRESH_JUNCTIONPOINT_NAME_PREFIX = "new_junction_"
    public static var FRESH_TRANSITION_NAME_PREFIX    = "new_transition_"

}